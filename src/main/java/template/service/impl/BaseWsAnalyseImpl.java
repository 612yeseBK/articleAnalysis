package template.service.impl;

import org.apache.log4j.Logger;
import template.service.BaseWsAnalyse;
import template.util.FcUtil;
import template.util.HeadEnum;
import template.util.POIUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class BaseWsAnalyseImpl implements BaseWsAnalyse {
    private static Logger log = org.apache.log4j.Logger.getLogger(BaseWsAnalyseImpl.class);
    List<String> wsnrList;
    private String wswjm;  //文书文件名
    private String wsnr; //文书内容
    private List<String> ws; //文首
    private List<String> sscyr; //诉讼参与人
    private String ssjl; //诉讼记录
    private List<String> ajjbqk; //案件基本情况
    private List<String> cpfxgc;  //裁判分析过程
    private List<String> cpjg; //裁判结果
    private List<String> ww;  //文尾
    private List<String> fl;  //附录
    /**
     * end为该段结束,上一段解析不出来，有可能end为-1，解析从end+1
     */
    private int end = -1;
    private int ajjbqkend = 0;
    private int ajjbqkpre = 0;

    public BaseWsAnalyseImpl() {
    }

    public BaseWsAnalyseImpl(String wswjm, String wsnr) {
        super();
        this.wswjm = wswjm;
        this.wsnr = wsnr;
        huaFen();
    }

    public BaseWsAnalyseImpl(byte[] wsByte, String wswjm) {
        super();
        try {
            this.wsnr = POIUtil.getWqcGString(wsByte, wswjm);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.wswjm = wswjm;
        huaFen();
    }

    /**
     * 获取首句截取的内容
     *
     * @param str
     * @return
     */
    public static String getContent(String str) {
        String temp = deBracket(str);
        int dh = (temp.indexOf("，") != -1 ? temp.indexOf("，") : temp.indexOf(","));  //逗号的位置，分中英文的
        int jh = (temp.indexOf("。") != -1 ? temp.indexOf("。") : temp.indexOf("."));  //句号的位置，分中英文
        int max;  //找到句号和逗号的最近的那一个
        if (dh == -1) {
            max = jh;
        } else if (jh == -1) {
            max = dh;
        } else {
            max = jh > dh ? dh : jh;
        }
        String content = "";
        try {
            content = temp.substring(0, max);  //这就截取了第一个逗号或者第一个句号的句子
        } catch (Exception e) {
        }
        return content;
    }

    /**
     * 去掉括号
     *
     * @param content
     * @return
     */
    public static String deBracket(String content) {
        int count = 20;
        while (((content.indexOf("（") != -1 && content.indexOf("）") != -1)
                || (content.indexOf("(") != -1 && content.indexOf(")") != -1)) && count > 0) {
            count--;
            int left = content.indexOf("（");
            int right = content.indexOf("）");
            if (left != -1) {
                if (right != -1) {
                    content = content.substring(0, left)
                            + content
                            .substring(right + 1, content.length());
                }
            }
            left = content.indexOf("(");
            right = content.indexOf(")");
            if (left != -1) {
                if (right != -1) {
                    content = content.substring(0, left)
                            + content
                            .substring(right + 1, content.length());
                }
            }
        }
        return content;
    }

    /**
     * 取得括号中的内容,不存在则返回null
     *
     * @param content
     * @return
     */
    public static String takeBracket(String content) {
        if ((content.indexOf("（") != -1 && content.indexOf("）") != -1)
                || (content.indexOf("(") != -1 && content.indexOf(")") != -1)) {
            int left = content.indexOf("（");
            int right = content.indexOf("）");
            if (left != -1) {
                if (right != -1) {
                    if (left + 1 < right)
                        content = content.substring(left + 1, right);
                }
            }
            left = content.indexOf("(");
            right = content.indexOf(")");
            if (left != -1) {
                if (right != -1) {
                    content = content.substring(left + 1, right);
                }
            }
        } else {
            content = null;
        }
        return content;
    }

    /**
     * 获取截取的内容
     * 句号，逗号，分号分割后的小句子
     *
     * @param str
     * @return
     */
    public static ArrayList<String> getWholeContent(String str) {
        ArrayList<String> contentlist = new ArrayList<String>();
        String[] jhsplit = str.split("。");
        for (int i = 0; i < jhsplit.length; i++) {
            String content = jhsplit[i];
            String[] dhsplit = content.split("，");
            for (int j = 0; j < dhsplit.length; j++) {
                String dhcontent = dhsplit[j];
                String[] fhsplit = dhcontent.split("；");
                for (int k = 0; k < fhsplit.length; k++) {
                    if (fhsplit[k].length() > 0) {
                        contentlist.add(fhsplit[k]);
                    }
                }
            }
        }
        return contentlist;
    }

    private void huaFen() {
        init();
        hfWs();
        hfSscyr();
        hfSsjl();
        hfCpfxgc();
        hfCpjg();
        hfAjjbqk();
        hfWw();
        hfFl();
    }

    @Override
    public void init() {
        if (wsnr != null) {
            //System.out.println(wsnr);
            wsnr = wsnr.replaceAll("[\\r]", "");
            /**
             * 去除全角半角空格
             */
            wsnr = wsnr.replaceAll("　", "");
            wsnr = wsnr.replaceAll(" ", "");
            String[] qfsjo = wsnr.split("\n");  //以换行符作为分割，分割出了所有的行
            String[] qfsj = new String[qfsjo.length];  //最后存储的是所有非空行的字符串
            int preindex = 0; //这里是全文的行数，非空行
            for (int i = 0; i < qfsjo.length; i++) {
                ArrayList<String> str = (ArrayList<String>) FcUtil.getWholeToken(qfsjo[i]);  //防止出现空行
                //显然这里统计的是非空行，也就是最后preindex的值会是所有的非空行的行数
                //而qfsjo.length则是指所有行的行数
                if (str.size() > 0) {
                    qfsj[preindex] = qfsjo[i];
                    preindex++;
                }
            }
            wsnrList = new ArrayList<>();
            String rexExp = "[.。:：;?？)）\"”]";
            Pattern pattern = Pattern.compile(rexExp);//匹配标点符号 这一般是文尾的正则
            String headExp = "[院|书|号]";  //匹配院书号三个字，这是文首正则
            Pattern pattern_ws = Pattern.compile(headExp);
            StringBuffer paragraph = new StringBuffer();
            int index = 0;
            //找到裁判结果的最后一行
            for (int i = 0; i < preindex; i++) {
                if (!qfsj[i].equals("")) {  //如果该行不为空
                    if (isCpjgEnd(qfsj[i])) {  //如果该行是裁判结果的哪一行，那么就将index记录下裁判结果这一行
                        index = i;
                        break;
                    }
                }
            }
            // 过滤数据把空格一行去掉并且将如果这段最后一个字不是标点符号自动默认跟下一行为一段
            int whitespaceNum = 0;
            for (int i = 0; i < preindex; i++) {
                if (qfsj[i].equals("")) {  //如果是空行，空行数目加一
                    whitespaceNum++;
                }
                if (!qfsj[i].equals("")) {
                    String str = qfsj[i];
                    paragraph.append(str);  //如果不是空行则加入这一个段落里面
                    if (!str.equals("")) {
                        //截取最后一个字符判断
                        String temp = str.substring(str.length() - 1);
                        Matcher matcher = pattern.matcher(temp);
                        Matcher wsMarcher = pattern_ws.matcher(temp);
                        /**
                         * 如果他最后一个字符合文首正则，则默认他可以无标点换行
                         * 且他如果包含文尾敏感词眼则认为他也可以无标点换行
                         */
                        if (whitespaceNum > 30) { //空行过多，可能表示这不是判决书
                            if (matcher.find() || (wsMarcher.find()) || index <= i) {  //matcher.find表示找到了
                                //把这段加进来并且清空paragraph
                                wsnrList.add(paragraph.toString());
                                paragraph.delete(0, paragraph.length());
                            }
                        } else {
                            if (matcher.find() || (wsMarcher.find() && i < 5) || index <= i) {
                                wsnrList.add(paragraph.toString());
                                paragraph.delete(0, paragraph.length());
                            }
                        }
                    }
                }
            }
            wsnrList.add(paragraph.toString());
        }
        log.info("wsnrList:" + wsnrList);
    }

    private boolean isCpjgEnd(String word) {
        if (word.contains("审判长") || word.contains("审判员") || word.contains("书记员")
                || word.contains("代理审判员") || word.contains("速录员") || word.contains("人民陪审员"))
            return true;
        return false;
    }

    @Override
    public void hfWs() {
        int index;
        if (wsnrList.size() < 10)
            index = wsnrList.size();
        else
            index = 10;
        for (int i = 0; i < index; i++) {
            if (HeadEnum.HasHead(wsnrList.get(i))) {
                end = i - 1; //一般文首之后就是诉讼参与人的信息，所以end记录就是诉讼参与人前一行的位置=行数-1
                break;
            }
        }
        // 当end>=0就表示文首是有的
        if (end >= 0) {
            ws = new ArrayList<>();
        }
        String find = "法院|书|号";  //山东省郓城县人民法院, 民事判决书, （2015）郓民初字第1024号,主要是为了匹配前三个句子
        Pattern p = Pattern.compile(find);
        for (int i = 0; i < wsnrList.size() && i < end + 1; i++) {
            Matcher matcher = p.matcher(wsnrList.get(i));
            if (matcher.find() && FcUtil.getWholeToken(wsnrList.get(i)).size() < 15) {
                //只有那些文首分词数目在15以下的才算是文首，估计有某些意外的情况需要这个限定
                ws.add(wsnrList.get(i));
            }
        }
    }

    @Override
    public void hfSscyr() {
        int pre = ++end; //end表示是文首的位置，+1之后一般就是诉讼参与人的位置
        for (int i = end; i < wsnrList.size(); i++) {
            if (wsnrList.get(i).contains("一案")) {
                end = i;  //这里是一个书写规范，
                // 一般诉讼参与人后面都会有一个诉讼记录，诉讼记录都会以以下格式开头：
                // 原告张汝宝与被告任师强、李守威机动车交通事故责任纠纷一案
                //匹配到了一案就说明诉讼参与人介绍结束了，后面就是诉讼记录了
                break;
            }
            String sj = getContent(wsnrList.get(i));  //这里是获取这一段落的首句
            if (isNotSscyr(sj)) {
                end = i; //如果不是诉讼参与人，end记录这个位置，并结束寻找诉讼参与人
                break;
            }
            if (likeSscyr(sj)) {
                continue;  //如果像诉讼参与人，则继续进行下一次循环，继续找诉讼参与人
            } else {  //否则，不像是诉讼参与人，则继续看下一句
                if (i + 1 < wsnrList.size()) {
                    sj = getContent(wsnrList.get(i + 1));
                    if (isNotSscyr(sj)) {
                        end = i;
                        break;
                    }
                    if (!likeSscyr(sj)) {
                        end = i;
                        break;
                    }
                }
            }
        }
        if (end > pre) { //end在之前的循环里面获取的是诉讼参与人的结束位置，如果end>pre,则表示有诉讼参与人这一个信息
            sscyr = new ArrayList<>();
        }
        end--;
        for (int i = pre; i < end + 1 && i < wsnrList.size(); i++) {
            sscyr.add(wsnrList.get(i));  //从pre开始到end结束，这是诉讼参与人的段落
        }
    }

    /**
     * 根据首句的分词来判断，小于10个分词的有可能是诉讼参与人
     *
     * @param words
     * @return
     */
    public boolean likeSscyr(String words) {
        List<String> list = FcUtil.getWholeToken(words);
        return list.size() >= 15 ? false : true;
    }

    /**
     * 判断肯定不是诉讼参与人
     *
     * @param words
     * @return
     */
    private boolean isNotSscyr(String words) {
        /**
         * 没有诉讼地位的敏感词 有诉称 辨称 一案 不服 纠纷 或者同时出现原被告 分词大于15 或者有本院 有认为 有认定 的都不可能是诉讼参与人
         */
        if (words.contains("诉称") || words.contains("辨称")
                || words.contains("一案") || words.contains("不服")
                || words.contains("纠纷") || words.contains("起诉书")
                || (words.contains("原告") && words.contains("被告"))
                || !HeadEnum.HasHead(words)
                || words.contains("本院") || words.contains("认为")
                || words.contains("认定"))

            return true;
        return false;
    }

    @Override
    public void hfAjjbqk() {
        ajjbqkpre++;
        if (ajjbqkpre < ajjbqkend) {
            ajjbqk = new ArrayList<String>();
        }
        for (int i = ajjbqkpre; i < ajjbqkend && i < wsnrList.size(); i++) {
            ajjbqk.add(wsnrList.get(i));
        }
    }

    @Override
    public void hfSsjl() {
        int pre = ++end;  //end是诉讼参与人的最后一段，end+1就是诉讼记录
        ajjbqkpre = pre;
        ssjl = wsnrList.get(pre);

    }

    @Override
    public void hfCpfxgc() {
        int pre = 0;
        boolean b = false;
        //这里是从后往前数，end表示的诉讼记录的结束
        for (int i = wsnrList.size() - 1; i >= end; i--) {
            if (isCpfxgc_1(wsnrList.get(i))) {  //这里是在寻找裁判分析过程的开始句子
                pre = i;  //记录开始
                ajjbqkend = i; //裁判分析过程开始就是案件基本情况的结束
                b = true;
                break;
            }
        }
        if (b == false) {
            for (int i = wsnrList.size() - 1; i >= end; i--) {
                if (isCpfxgc_2(wsnrList.get(i))) {
                    pre = i;
                    ajjbqkend = i;
                    b = true;
                    break;
                }
            }
        }
        if (ajjbqkend != 0) {
            for (int i = pre; i < wsnrList.size(); i++) {
                if (isCpfxgcEnd(wsnrList.get(i))) {
                    end = i + 1; //结束之后。这是为了下一个要素进行标记，下一个是裁判结果
                    break;
                }
            }
            if (end > pre) {
                cpfxgc = new ArrayList<>();
            }
            end--;  //此处end记录的是裁判结果的开始
            for (int i = pre; i < end + 1 && i < wsnrList.size(); i++) {
                cpfxgc.add(wsnrList.get(i));
            }
        }
    }

    private boolean isCpfxgc_1(String word) {
        if (word.indexOf("本院认为") == 0 || word.indexOf("本院经审理认为") == 0
                || word.indexOf("本院经审查认为") == 0 || word.contains("主持调解")
                || word.indexOf("本院审查认为") == 0)
            //		if (word.contains(" 本院认为") || word.contains(" 本院经审查认为"))
            return true;
        if (word.contains("达成协议如下"))
            return true;
        return false;
    }

    private boolean isCpfxgc_2(String word) {
        if (word.contains("本院认为") || word.contains("本院经审理认为")
                || word.contains("本院经审查认为") || word.contains("主持调解")
                || word.contains("本院审查认为"))
            //		if (word.contains(" 本院认为") || word.contains(" 本院经审查认为"))
            return true;
        if (word.contains("达成协议如下"))
            return true;
        return false;
    }

    private boolean isCpfxgcEnd(String word) {
        if (word.contains("裁定如下") || word.contains("判决如下")
                || word.contains("决定如下"))
            return true;
        return false;
    }

    @Override
    public void hfCpjg() {
        if (ajjbqkend != 0) {
            int pre = ++end; //裁判结果段的开始
            for (int i = end; i < wsnrList.size(); i++) {
                if (isCpjgEnd(wsnrList.get(i))) {
                    end = i; //裁判结果的结束记录下来，为后面的文尾做准备
                    break;
                }
            }
            if (end > pre) {
                cpjg = new ArrayList<>();
            }
            end--;
            for (int i = pre; i < end + 1 && i < wsnrList.size(); i++) {
                cpjg.add(wsnrList.get(i));
            }
        } else {  //如果案件基本情况的end=0，那就需要继续寻找哪一个是案件基本情况的结束
            int pre = 0;
            for (int i = wsnrList.size() - 1; i >= end; i--) {
                if (isCpfxgcEnd(wsnrList.get(i))) {
                    pre = i + 1;  //如果是裁判分析过程的结束，那么下一句就是裁判结果的开始
                    ajjbqkend = i;  //案件基本情况的结束就是也是裁判分析过程的结束
                    break;
                }
            }
            for (int i = pre; i < wsnrList.size(); i++) {
                if (isCpjgEnd(wsnrList.get(i))) {
                    end = i;  //从裁判结果的开始，找到哪一个是裁判结果的结束
                    break;
                }
            }
            if (end > pre) {
                cpjg = new ArrayList<>();
            }
            end--;
            for (int i = pre; i < end + 1 && i < wsnrList.size(); i++) {
                cpjg.add(wsnrList.get(i));
            }
        }
    }

    @Override
    public void hfWw() {
        int pre = ++end;  //end上接裁判结果的结束，此处是文尾的开始
        boolean wwend = false;
        for (int i = end; i < wsnrList.size(); i++) {
            if (isWwEnd(wsnrList.get(i))) {
                wwend = true;  //找到了文尾的话，就将end记录下文尾的位置
                end = i + 1;
                break;
            }
            if (wsnrList.get(i).contains("附")) {
                wwend = true;  //这里是另一个找到文尾的方式，利用附录的方式去寻找文尾，文尾后面可能有附录
                end = i;
                break;
            }
            if (isFlEnd(wsnrList.get(i))) {
                wwend = true;
                end = i;
                break;
            }
        }
        if (wwend == false)  //如果没找到文尾的end，那就将全文的结尾段作为文尾的end
            end = wsnrList.size();
        if (end > pre) {
            ww = new ArrayList<String>();
        }
        end--;
        for (int i = pre; i < end + 1 && i < wsnrList.size(); i++) {
            ww.add(wsnrList.get(i));
        }
    }

    private boolean isWwEnd(String word) {
        if (word.contains("速录") && word.contains("书记")) {
            return true;
        } else if (word.indexOf("速录") > -1) {
            return true;
        }
        return false;
    }

    @Override
    public void hfFl() {
        int pre = ++end;  //这里是确定了附录的开始，上接裁判结果
        for (int i = end; i < wsnrList.size(); i++) {
            if (isFlEnd(wsnrList.get(i))) {
                end = i;  //这里记录了附录的结束
                break;
            }
        }
        if (end > pre) {
            fl = new ArrayList<>();
        }
        end--;
        for (int i = pre; i < end + 1 && i < wsnrList.size(); i++) {
            fl.add(wsnrList.get(i));
        }
    }

    private boolean isFlEnd(String word) {
        if (word.contains("PAGE"))
            return true;
        return false;
    }

    public String getWswjm() {
        return wswjm;
    }

    public void setWswjm(String wswjm) {
        this.wswjm = wswjm;
    }

    public String getWsnr() {
        return wsnr;
    }

    public void setWsnr(String wsnr) {
        this.wsnr = wsnr;
    }

    public List<String> getWs() {
        return ws;
    }

    public void setWs(List<String> ws) {
        this.ws = ws;
    }

    public List<String> getSscyr() {
        return sscyr;
    }

    public void setSscyr(List<String> sscyr) {
        this.sscyr = sscyr;
    }

    public List<String> getAjjbqk() {
        return ajjbqk;
    }

    public void setAjjbqk(List<String> ajjbqk) {
        this.ajjbqk = ajjbqk;
    }

    public List<String> getCpfxgc() {
        return cpfxgc;
    }

    public void setCpfxgc(List<String> cpfxgc) {
        this.cpfxgc = cpfxgc;
    }

    public List<String> getCpjg() {
        return cpjg;
    }

    public void setCpjg(List<String> cpjg) {
        this.cpjg = cpjg;
    }

    public List<String> getWw() {
        return ww;
    }

    public void setWw(List<String> ww) {
        this.ww = ww;
    }

    public List<String> getFl() {
        return fl;
    }

    public void setFl(List<String> fl) {
        this.fl = fl;
    }

    public String getSsjl() {
        return ssjl;
    }

    public void setSsjl(String ssjl) {
        this.ssjl = ssjl;
    }
}
