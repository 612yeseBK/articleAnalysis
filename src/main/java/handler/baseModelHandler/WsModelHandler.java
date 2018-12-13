package handler.baseModelHandler;

import model.WswsModel;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:用来处理文首的信息
 * Created by gaoyw on 2018/12/4.
 */
public class WsModelHandler {
    public WsModelHandler() {}

    public WswsModel jxWswsModel(List<String> ws) {
        WswsModel wswsModel = new WswsModel();
        String find1 = "法院";
        String find2 = "书";
        String find3 = "号";
        String wszzdw = "法院";
        wswsModel.setWszzdw(wszzdw);
        Pattern p1 = Pattern.compile(find1);
        Pattern p2 = Pattern.compile(find2);
        Pattern p3 = Pattern.compile(find3);

        for(int i = 0; i < ws.size(); ++i) {
            Matcher matcher1 = p1.matcher((CharSequence)ws.get(i));
            Matcher matcher2 = p2.matcher((CharSequence)ws.get(i));
            Matcher matcher3 = p3.matcher((CharSequence)ws.get(i));
            String jbfy;
            String[] zzqqj;
            String xzqhProv;
            String[] spcxjcqj;
            int j;
            if (matcher1.find()) {
                jbfy = (String)ws.get(i);
                wswsModel.setJbfy(jbfy);
                if (jbfy.contains("高级")) {
                    wswsModel.setFyjb("高级");
                } else if (jbfy.contains("中级")) {
                    wswsModel.setFyjb("中级");
                } else if (jbfy.contains("最高")) {
                    wswsModel.setFyjb("最高");
                } else {
                    wswsModel.setFyjb("基层");
                }

                String[] zxsqj = new String[]{"北京", "天津", "上海", "重庆"};
                zzqqj = new String[]{"内蒙古", "广西", "西藏", "宁夏", "新疆"};
                xzqhProv = null;
                boolean hasZzs = false;
                spcxjcqj = zxsqj;
                j = zxsqj.length;

                int var21;
                String zzq;
                for(var21 = 0; var21 < j; ++var21) {
                    zzq = spcxjcqj[var21];
                    if (jbfy.contains(zzq)) {
                        xzqhProv = zzq;
                        hasZzs = true;
                    }
                }

                spcxjcqj = zzqqj;
                j = zzqqj.length;

                for(var21 = 0; var21 < j; ++var21) {
                    zzq = spcxjcqj[var21];
                    if (jbfy.contains(zzq)) {
                        xzqhProv = zzq;
                    }
                }

                if (jbfy.indexOf("省") != -1) {
                    xzqhProv = jbfy.substring(0, jbfy.indexOf("省"));
                }

                wswsModel.setXzqhProv(xzqhProv);
                String xzqhCity = null;
                if (jbfy.indexOf("市") != -1 && jbfy.indexOf("省") != -1) {
                    if (jbfy.indexOf("省") < jbfy.indexOf("市")) {
                        xzqhCity = jbfy.substring(jbfy.indexOf("省") + 1, jbfy.indexOf("市") + 1);
                    }
                } else if (jbfy.indexOf("市") != -1 && jbfy.indexOf("自治区") != -1) {
                    if (jbfy.indexOf("区") < jbfy.indexOf("市")) {
                        xzqhCity = jbfy.substring(jbfy.indexOf("区") + 1, jbfy.indexOf("市") + 1);
                    }
                } else if (jbfy.indexOf("市") != -1 && !hasZzs) {
                    if (0 < jbfy.indexOf("市")) {
                        xzqhCity = jbfy.substring(0, jbfy.indexOf("市") + 1);
                    }
                } else if (jbfy.indexOf("市") == -1) {
                    xzqhCity = xzqhProv;
                }

                String[] var32 = zxsqj;
                var21 = zxsqj.length;

                for(int var33 = 0; var33 < var21; ++var33) {
                    String zzx = var32[var33];
                    if (jbfy.contains(zzx)) {
                        if (jbfy.contains("第一中级")) {
                            xzqhCity = "一中院";
                        } else if (jbfy.contains("第二中级")) {
                            xzqhCity = "二中院";
                        } else if (jbfy.contains("第三中级")) {
                            xzqhCity = "三中院";
                        } else {
                            xzqhCity = null;
                        }
                    }
                }

                wswsModel.setXzqhCity(xzqhCity);
            }

            String temp;
            String str;
            if (matcher2.find()) {
                jbfy = (String)ws.get(i);
                wswsModel.setWsmc(jbfy);
                temp = null;
                if (jbfy.length() > 3) {
                    temp = jbfy.substring(0, 2);
                }

                wswsModel.setAjxz(temp + "案件");
                str = null;
                int index_shu = jbfy.indexOf("书");
                if (index_shu != -1 && index_shu - 2 < index_shu + 1 && index_shu - 2 < index_shu + 1 && index_shu - 2 > 0) {
                    str = jbfy.substring(index_shu - 2, index_shu + 1);
                }

                wswsModel.setWszl(str);
            }

            if (matcher3.find()) {
                wswsModel.setAh((String)ws.get(i));
                jbfy = "2016";
                temp = (String)ws.get(i);
                zzqqj = null;
                if (temp != null) {
                    temp = temp.replace("（", "(");
                    temp = temp.replace("）", ")");
                }

                if (temp.indexOf("（") != -1 && temp.indexOf("）") != -1) {
                    if (temp.lastIndexOf("（") <= temp.lastIndexOf("）")) {
                        str = temp.substring(temp.lastIndexOf("（"), temp.lastIndexOf("）"));
                        jbfy = str.substring(1, str.length());
                    }
                } else if (temp.indexOf("(") != -1 && temp.indexOf(")") != -1) {
                    if (temp.lastIndexOf("(") <= temp.lastIndexOf(")")) {
                        str = temp.substring(temp.lastIndexOf("("), temp.lastIndexOf(")"));
                        jbfy = str.substring(1, str.length());
                    }
                } else if (temp.indexOf("〔") != -1 && temp.indexOf("〕") != -1 && temp.lastIndexOf("〔") <= temp.lastIndexOf("〕")) {
                    str = temp.substring(temp.lastIndexOf("〔"), temp.lastIndexOf("〕"));
                    jbfy = str.substring(1, str.length());
                }

                if (jbfy != null) {
                    wswsModel.setLand(jbfy);
                }

                xzqhProv = null;
                String[] spcxqj = new String[]{"一审", "二审", "再审"};
                spcxjcqj = new String[]{"初", "终", "再"};

                for(j = 0; j < spcxqj.length; ++j) {
                    if (temp.contains(spcxjcqj[j])) {
                        xzqhProv = spcxqj[j];
                    }
                }

                wswsModel.setSpcx(xzqhProv + "案件");
            }
        }

        String ajlx = null;
        String ajxz = wswsModel.getAjxz();
        String spcx = wswsModel.getSpcx();
        if (ajxz != null && wswsModel.getSpcx() != null && ajxz.contains("案件")) {
            ajlx = ajxz.substring(0, ajxz.indexOf("案件")) + wswsModel.getSpcx();
        }

        wswsModel.setAjlx(ajlx);
        return wswsModel;
    }
}
