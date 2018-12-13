package service.impl;

import service.WsAnalyse;
import util.FcUtil;
import util.HeadEnum;
import util.POIUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class WsAnalyseImpl implements WsAnalyse {

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

    public WsAnalyseImpl() {
    }

    public WsAnalyseImpl(String wswjm, String wsnr) {
        super();
        this.wswjm = wswjm;
        this.wsnr = wsnr;
        huaFen();
    }

    public WsAnalyseImpl(byte[] wsByte, String wswjm) {
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
                    if (isCpjgEnd(qfsj[i])) {  //并且是裁判结果的结束
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
                if (!qfsj[i].equals("")) {  //如果不是空行
                    String str = qfsj[i];
                    paragraph.append(str);
                    if (!str.equals("")) {
                        //截取最后一个字符判断
                        String temp = str.substring(str.length() - 1);
                        Matcher matcher = pattern.matcher(temp);
                        Matcher wsMarcher = pattern_ws.matcher(temp);
                        /**
                         * 如果他最后一个字符合文首正则，则默认他可以无标点换行
                         * 且他如果包含文尾敏感词眼则认为他也可以无标点换行
                         *
                         * index <= i表示的是这一行的行数已经大于所有非空行的数目
                         */
                        if (whitespaceNum > 30) {
                            if (matcher.find() || (wsMarcher.find()) || index <= i) {
                                //把这段加进来并且清空paragraph
                                wsnrList.add(paragraph.toString());
                                paragraph.delete(0, paragraph.length());
                            }
                        } else {
                            if (matcher.find() || (wsMarcher.find() && i < 5) || index <= i) {
                                //把这段加进来并且清空paragraph
                                wsnrList.add(paragraph.toString());
                                paragraph.delete(0, paragraph.length());
                            }
                        }

                    }
                }
            }
            wsnrList.add(paragraph.toString());
        }
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
                end = i - 1;
                break;
            }
        }
        // 当end
        if (end >= 0) {
            ws = new ArrayList<String>();
        }
        String find = "法院|书|号";
        Pattern p = Pattern.compile(find);
        for (int i = 0; i < wsnrList.size() && i < end + 1; i++) {
            Matcher matcher = p.matcher(wsnrList.get(i));
            if (matcher.find() && FcUtil.getWholeToken(wsnrList.get(i)).size() < 15) {
                ws.add(wsnrList.get(i));
            }
        }
    }

    @Override
    public void hfSscyr() {

    }

    @Override
    public void hfAjjbqk() {

    }

    @Override
    public void hfSsjl() {

    }

    @Override
    public void hfCpfxgc() {

    }

    @Override
    public void hfCpjg() {

    }

    @Override
    public void hfWw() {

    }

    @Override
    public void hfFl() {

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
