package template.handler.baseModelHandler;

import template.model.BaseModel.BaseWSModel;
import template.util.StringUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:用来处理文首的信息
 * Created by gaoyw on 2018/12/4.
 */
public class BaseWSModelHandler {
    public BaseWSModelHandler() {
    }

    public BaseWSModel jxWswsModel(List<String> ws) {
        BaseWSModel baseWSModel = new BaseWSModel();
        String find1 = "法院";
        String find2 = "书";
        String find3 = "号";
        String wszzdw = "法院";
        baseWSModel.setWszzdw(wszzdw);
        Pattern p1 = Pattern.compile(find1);
        Pattern p2 = Pattern.compile(find2);
        Pattern p3 = Pattern.compile(find3);

        for (int i = 0; i < ws.size(); ++i) {
            Matcher matcher1 = p1.matcher(ws.get(i));
            Matcher matcher2 = p2.matcher(ws.get(i));
            Matcher matcher3 = p3.matcher(ws.get(i));
            if (matcher1.find()) {
                dealFaYuan(ws.get(i), baseWSModel);
            }
            if (matcher2.find()) {
                dealWenShuXingZhi(ws.get(i), baseWSModel);
            }
            if (matcher3.find()) {
                dealAnHao(ws.get(i), baseWSModel);
            }
        }

        String ajlx = null;
        String ajxz = baseWSModel.getAjxz();
        if (ajxz != null && baseWSModel.getSpcx() != null && ajxz.contains("案件")) {
            ajlx = ajxz.substring(0, ajxz.indexOf("案件")) + baseWSModel.getSpcx();
        }
        baseWSModel.setAjlx(ajlx);
        return baseWSModel;
    }


    public void dealFaYuan(String jbfy, BaseWSModel baseWSModel) {
        baseWSModel.setJbfy(jbfy);
        if (jbfy.contains("高级")) {
            baseWSModel.setFyjb("高级");
        } else if (jbfy.contains("中级")) {
            baseWSModel.setFyjb("中级");
        } else if (jbfy.contains("最高")) {
            baseWSModel.setFyjb("最高");
        } else {
            baseWSModel.setFyjb("基层");
        }
        dealXzqh(jbfy, baseWSModel);
    }

    public void dealXzqh(String jbfy, BaseWSModel baseWSModel) {
        String[] zxsqj = new String[]{"北京", "天津", "上海", "重庆"};  //直辖市全集
        String[] zzqqj = new String[]{"内蒙古", "广西", "西藏", "宁夏", "新疆"};  //自治区全集

        String xzqhProv = null;
        String xzqhCity = null;
        if (!dealZZQandZXS(jbfy, baseWSModel)) {//如果不是自治区和直辖市
            if (jbfy.indexOf("省") != -1) {
                xzqhProv = jbfy.substring(0, jbfy.indexOf("省"));
            }
            if (jbfy.indexOf("市") != -1 && jbfy.indexOf("省") != -1) {  //有省有市
                if (jbfy.indexOf("省") < jbfy.indexOf("市")) {
                    xzqhCity = jbfy.substring(jbfy.indexOf("省") + 1, jbfy.indexOf("市") + 1);
                }
            } else if (jbfy.indexOf("市") != -1 && jbfy.indexOf("省") == -1) {  //有市没省
                xzqhCity = jbfy.substring(0, jbfy.indexOf("市") + 1);
            } else if (jbfy.indexOf("市") == -1 && jbfy.indexOf("省") != -1) { //没市有省
                xzqhCity = xzqhProv;
            }
            //没市，没省的继续保持初始化为null

            baseWSModel.setXzqhProv(xzqhProv);
            baseWSModel.setXzqhCity(xzqhCity);
        }


    }

    public boolean dealZZQandZXS(String jbfy, BaseWSModel baseWSModel) {
        String[] zxsqj = new String[]{"北京", "天津", "上海", "重庆"};  //直辖市全集
        String[] zzqqj = new String[]{"内蒙古", "广西", "西藏", "宁夏", "新疆"};  //自治区全集
        String xzqhProv = null;
        String xzqhCity = null;
        for (int i = 0; i < zxsqj.length; i++) {
            String zxs = zxsqj[i];
            if (jbfy.contains(zxs)) {
                xzqhProv = zxs;
                if (jbfy.indexOf("区") < jbfy.indexOf("市")) {
                    //对于直辖市而言，其行政区划的市就是一般意义的区
                    xzqhCity = jbfy.substring(jbfy.indexOf("区") + 1, jbfy.indexOf("市") + 1);
                } else if (jbfy.contains("第一中级")) { //对于没有区一级的数据，那么可以按照第一中级等划分
                    xzqhCity = "一中院";
                } else if (jbfy.contains("第二中级")) {
                    xzqhCity = "二中院";
                } else if (jbfy.contains("第三中级")) {
                    xzqhCity = "三中院";
                } else {
                    xzqhCity = null;
                }
                baseWSModel.setXzqhProv(xzqhProv);
                baseWSModel.setXzqhCity(xzqhCity);
                return true;
            }
        }
        if (StringUtil.isEmpty(xzqhProv)) {
            for (int i = 0; i < zzqqj.length; i++) {
                String zzq = zzqqj[i];
                if (jbfy.contains(zzq)) {
                    xzqhProv = zzq;
                    if (jbfy.indexOf("市") != -1 && jbfy.indexOf("自治区") != -1) {
                        //对于自治区而言，去行政区划的市就是区一般意义的市，不过会跟在自治区后面
                        if (jbfy.indexOf("区") < jbfy.indexOf("市")) {
                            xzqhCity = jbfy.substring(jbfy.indexOf("区") + 1, jbfy.indexOf("市") + 1);
                        }
                    }
                    baseWSModel.setXzqhProv(xzqhProv);
                    baseWSModel.setXzqhCity(xzqhCity);
                    return true;
                }
            }
        }
        return false;
    }

    public void dealWenShuXingZhi(String wsName, BaseWSModel baseWSModel) {
        baseWSModel.setWsmc(wsName);
        String ajlx = null;
        if (wsName.length() > 3) {
            ajlx = wsName.substring(0, 2);
        }
        baseWSModel.setAjxz(ajlx + "案件");

        String wszl = null;
        int index_shu = wsName.indexOf("书");
        if (index_shu != -1 && index_shu - 2 < index_shu + 1 && index_shu - 2 > 0) {
            wszl = wsName.substring(index_shu - 2, index_shu + 1);
        }
        baseWSModel.setWszl(wszl);
    }

    public void dealAnHao(String anHao, BaseWSModel baseWSModel) {
        String land = null;
        String spcx = null;
        if (anHao != null) {
            anHao = anHao.replace("（", "(");
            anHao = anHao.replace("）", ")");
        }
        if (anHao.indexOf("(") != -1 && anHao.indexOf(")") != -1) {
            if (anHao.lastIndexOf("(") <= anHao.lastIndexOf(")")) {
                String str = anHao.substring(anHao.lastIndexOf("("), anHao.lastIndexOf(")"));
                land = str.substring(1, str.length());
            }
        }

        String[] spcxqj = new String[]{"一审", "二审", "再审"};  //实际填写的字眼
        String[] spcxjcqj = new String[]{"初", "终", "再"};  //文书里面的字眼
        for (int k = 0; k < spcxqj.length; ++k) {
            if (anHao.contains(spcxjcqj[k])) {
                spcx = spcxqj[k];
            }
        }
        baseWSModel.setSpcx(spcx + "案件");
        baseWSModel.setAh(anHao);
        baseWSModel.setLand(land);
    }
}

