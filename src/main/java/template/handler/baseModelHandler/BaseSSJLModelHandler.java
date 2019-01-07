package template.handler.baseModelHandler;

import template.model.BaseModel.BaseSSCYRQJModel;
import template.model.BaseModel.BaseSSJLModel;
import template.model.another.WssscyrModel;
import template.model.another.WsssjlModel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * description:诉讼记录
 * Created by gaoyw on 2018/12/13.
 */
public class BaseSSJLModelHandler {
    public BaseSSJLModelHandler() {
    }

    public BaseSSJLModel jxWsssjlModel(BaseSSCYRQJModel baseSSCYRQJModel, String wsssjl) {
        List<WssscyrModel> wssscyrModellist = new ArrayList<>();
        List<BaseSSCYRQJModel.SSCYR> sscyrs = baseSSCYRQJModel.getSSCYRQJ();
        BaseSSJLModel baseSSJLModel = new BaseSSJLModel();
        WsssjlModel wsssjlModel = new WsssjlModel();
        String[] contentArray = wsssjl.split("，|,|\\.|。|、|;|；");
        String ay = null;
        String aydm = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String ktsl;
        String ktslxx;
        String larq;
        String all_ay;
        int i;
        String content;
        try {
            String single_ay;
            ArrayList<String> ayList = new ArrayList();
            ktsl = "";
            ktslxx = System.getProperty("user.dir") + File.separator + "msaymc_aydm.txt";
            all_ay = System.getProperty("user.dir") + File.separator + "msaymc_aydm.txt";
//            fis = new FileInputStream(ktslxx);
            fis = new FileInputStream(all_ay);
            isr = new InputStreamReader(fis, "utf-8");
            br = new BufferedReader(isr);

            while((ktsl = br.readLine()) != null) {
                ayList.add(ktsl);
            }

            for(int j = 0; j < ayList.size(); ++j) {
                single_ay = (ayList.get(j)).substring(5, (ayList.get(j)).length());
                if (wsssjl.contains(single_ay)) {
                    ay = single_ay;
                    aydm = (ayList.get(j)).substring(0, 4);
                }
            }

            if (ay != null && aydm != null) {
//                wsssjlModel.setAy(ay);
//                wsssjlModel.setWzay(ay);
//                wsssjlModel.setAydm(aydm);
                baseSSJLModel.setAy(ay);
                baseSSJLModel.setAydm(aydm);
//            } else if (wssscyrModellist != null && wsssjl != null) {
//                content = "";
//                content = BaseWsAnalyseImpl.getContent(wsssjl);
//                int prefix = 0;
//                int suffix = content.indexOf("一案");
//                if (suffix != -1) {
//                    Iterator var17 = wssscyrModellist.iterator();
//
//                    while(var17.hasNext()) {
//                        WssscyrModel template.model = (WssscyrModel)var17.next();
//                        i = content.indexOf(template.model.getSscyr());
//                        if (i != -1 && i + template.model.getSscyr().length() > prefix) {
//                            if (content.indexOf("因") == i + 1) {
//                                prefix = i + template.model.getSscyr().length() + 1;
//                            } else {
//                                prefix = i + template.model.getSscyr().length();
//                            }
//                        }
//                    }
//
//                    ay = content.substring(prefix, suffix);
//                    if (ay != null) {
//                        wsssjlModel.setAy(ay);
//                        wsssjlModel.setWzay(ay);
//                    }
//                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("找不到指定文件");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }

        String ajly = null;
        if (wsssjl.contains("管辖权")) {
            ajly = "对管辖权异议裁定不服上诉";
        } else if (wsssjl.contains("不服")) {
            if (wsssjl.contains("判决")) {
                ajly = "对判决不服上诉";
            } else if (wsssjl.contains("裁定")) {
                if (wsssjl.contains("不予受理")) {
                    ajly = "对裁定不予受理不服上诉";
                } else if (wsssjl.contains("驳回起诉")) {
                    ajly = "对裁定驳回起诉不服上诉";
                }
            }
        }

//        wsssjlModel.setAjly(ajly);
        ktsl = "否";
        ktslxx = null;
        content = "其他";
        if ((wsssjl.contains("开庭") || wsssjl.contains("合议庭")) && wsssjl.contains("审理") && !wsssjl.contains("不开庭")) {
            ktsl = "是";
            if (wsssjl.contains("不公开")) {
                ktslxx = "不公开审理";
                if (wsssjl.contains("离婚")) {
                    content = "当事人申请不公开审理的离婚案件";
                } else if (wsssjl.contains("未成年")) {
                    content = "当事人申请不公开审理的涉及未成年案件";
                } else if (wsssjl.contains("商业秘密")) {
                    content = "当事人申请不公开审理的涉及商业秘密案件";
                } else if (wsssjl.contains("隐私")) {
                    content = "当事人申请不公开审理的涉及个人隐私的案件";
                } else if (wsssjl.contains("国家秘密")) {
                    content = "涉及国家秘密案件";
                }
            } else {
                ktslxx = "公开审理";
            }
        }

        wsssjlModel.setKtsl(ktsl);
        wsssjlModel.setKtslxx(ktslxx);
        wsssjlModel.setBgkslyy(content);
        baseSSJLModel.setKtsl(ktsl);
        baseSSJLModel.setKtslxx(ktslxx);
        larq = null;
        String slrq = null;
        String sqcsrq = null;
        ArrayList<String> ktrq = new ArrayList();

        for(i = 0; i < contentArray.length; ++i) {
            if (!contentArray[i].contains("立案") && !contentArray[i].contains("受理")) {
                if (contentArray[i].contains("开庭")) {
                    ktrq.add(getDate(contentArray[i]));
                } else if (!contentArray[i].contains("申请撤") && !contentArray[i].contains("撤诉申请") && !contentArray[i].contains("提出撤") && !contentArray[i].contains("提出申请")) {
                    ktrq.add(getDate(contentArray[i]));
                } else {
                    sqcsrq = getDate(contentArray[i]);
                }
            } else {
                larq = getDate(contentArray[i]);
                if (contentArray[i].contains("受理")) {
                    slrq = getDate(contentArray[i]);
                }
            }
        }

        if (larq != null) {
            wsssjlModel.setLarq(larq);
            baseSSJLModel.setLarq(larq);
        }

        if (ktrq != null) {
            wsssjlModel.setKtrq(ktrq);
        }

        if (slrq != null) {
            wsssjlModel.setSlrq(slrq);
        }

        if (sqcsrq != null) {
            wsssjlModel.setSqcsrq(sqcsrq);
        }

//        String ajsj = null;
//        if (wsssjl.contains("农民工工资")) {
//            ajsj = "涉农民工工资";
//        } else if (wsssjl.contains("征地补偿")) {
//            ajsj = "涉征地补偿";
//        } else if (wsssjl.contains("拆迁安置补偿")) {
//            ajsj = "涉拆迁安置补偿";
//        } else if (wsssjl.contains("产品质量")) {
//            ajsj = "涉产品质量";
//        } else if (wsssjl.contains("环境污染")) {
//            ajsj = "涉环境污染";
//        } else if (wsssjl.contains("医院")) {
//            ajsj = "涉医疗纠纷";
//        } else if (wsssjl.contains("合同欺诈")) {
//            ajsj = "涉合同欺诈";
//        } else if (wsssjl.contains("服务欺诈")) {
//            ajsj = "涉服务欺诈";
//        } else if (wsssjl.contains("保险欺诈")) {
//            ajsj = "涉保险欺诈";
//        } else if (wsssjl.contains("贷款欺诈")) {
//            ajsj = "涉贷款欺诈";
//        } else if (wsssjl.contains("婚外情")) {
//            ajsj = "涉婚外情";
//        } else if (wsssjl.contains("知识产权")) {
//            ajsj = "涉知识产权";
//        } else if (wsssjl.contains("海事海商")) {
//            ajsj = "涉海事海商";
//        } else if (wsssjl.contains("WTO规则")) {
//            ajsj = "涉WTO规则";
//        } else if (wsssjl.contains("军队")) {
//            ajsj = "涉军";
//        }
//
//        wsssjlModel.setAjsj(ajsj);
//        ArrayList<String> qsah = new ArrayList();
//        String reg = "[（\\(（〔]\\d{4}[）\\)〕）].+?[^鉴]字第?\\d+-?\\d+号";
//        Pattern p = Pattern.compile(reg);
//        Matcher m = p.matcher(wsssjl);
//
//        while(m.find()) {
//            qsah.add(m.group());
//        }
//
//        wsssjlModel.setQsah(qsah);
//        String ysajsycx = "普通程序";
//        String jyzpt = "否";
//        if (!wsssjl.contains("简易程序") && !wsssjl.contains("小额诉讼程序")) {
//            if (wsssjl.contains("转为普通")) {
//                ysajsycx = "普通程序";
//                jyzpt = "是";
//            }
//        } else if (wsssjl.contains("不宜适用简易")) {
//            ysajsycx = "普通程序";
//        } else {
//            ysajsycx = "简易程序";
//        }
//
//        wsssjlModel.setYsajsycx(ysajsycx);
//        wsssjlModel.setJyzpt(jyzpt);
        HashMap<String, String> qxrmap = new HashMap();
        HashMap<String, String> ctrmap = new HashMap();
        ArrayList<String> qxgjc = new ArrayList();
        qxgjc.add("未到");
        qxgjc.add("没有到");
        qxgjc.add("拒不到");
        int index = -1;
        if (/*wsssjlModel.getKtsl() == "是"*/baseSSJLModel.getKtsl() == "是") {
            int beginIndex = wsssjl.indexOf("一案");
            Iterator var31;
            BaseSSCYRQJModel.SSCYR model;
            if (wsssjl.contains("到庭") && beginIndex != -1) {
                for(i = 0; i < qxgjc.size(); ++i) {
                    if (wsssjl.contains(qxgjc.get(i))) {
                        index = wsssjl.lastIndexOf(qxgjc.get(i));
                        if (index != -1) {
                            if (wsssjl.indexOf("到庭") < index) {
//                                var31 = wssscyrModellist.iterator();
                                var31 = sscyrs.iterator();

                                while(var31.hasNext()) {
                                    model = (BaseSSCYRQJModel.SSCYR)var31.next();
                                    if (model.getSscyrmc() != null) {
                                        if (wsssjl.substring(beginIndex, wsssjl.indexOf("到庭")).contains(model.getSscyrmc())) {
                                            if (!ctrmap.containsKey(model.getSscyrmc())) {
                                                ctrmap.put(model.getSscyrmc(), model.getSssf());
                                            }
                                        } else if (wsssjl.substring(wsssjl.substring(0, index).lastIndexOf("到庭"), index).contains(model.getSscyrmc())) {
                                            qxrmap.put(model.getSscyrmc(), model.getSssf());
                                        }
                                    }
                                }
                            } else {
                                var31 = sscyrs.iterator();

                                while(var31.hasNext()) {
                                    model = (BaseSSCYRQJModel.SSCYR)var31.next();
                                    if (model.getSscyrmc() != null) {
                                        if (wsssjl.substring(beginIndex, index).contains(model.getSscyrmc())) {
                                            if (!ctrmap.containsKey(model.getSscyrmc())) {
                                                ctrmap.put(model.getSscyrmc(), model.getSssf());
                                            }
                                        } else if (wsssjl.substring(index, wsssjl.lastIndexOf("到庭")).contains(model.getSscyrmc())) {
                                            qxrmap.put(model.getSscyrmc(), model.getSssf());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (index == -1) {
                    Iterator var52 = sscyrs.iterator();
                    while(var52.hasNext()) {
                        BaseSSCYRQJModel.SSCYR model2 = (BaseSSCYRQJModel.SSCYR)var52.next();
                        if (model2.getSscyrmc() != null && wsssjl.substring(beginIndex, wsssjl.lastIndexOf("到庭")).contains(model2.getSscyrmc()) && !ctrmap.containsKey(model2.getSscyrmc())) {
                            ctrmap.put(model2.getSscyrmc(), model2.getSssf());
                        }
                    }
                }
            } else if (beginIndex != -1) {
                for(i = 0; i < qxgjc.size(); ++i) {
                    if (wsssjl.contains(qxgjc.get(i))) {
                        index = wsssjl.lastIndexOf(qxgjc.get(i));
                        var31 = sscyrs.iterator();
                        while(var31.hasNext()) {
                            model = (BaseSSCYRQJModel.SSCYR)var31.next();
                            if (model.getSscyrmc() != null && wsssjl.substring(beginIndex, index).contains(model.getSscyrmc())) {
                                qxrmap.put(model.getSscyrmc(), model.getSssf());
                            }
                        }
                    }
                }
            }
        }

//        wsssjlModel.setQxrxx(qxrmap);
//        wsssjlModel.setCtrxx(ctrmap);
        baseSSJLModel.setCtdsrxx(ctrmap);


        return baseSSJLModel;
    }

    public static String getDate(String str) {
        String date = null;
        if (str.length() > 8 && str.contains("年") && str.contains("月") && str.contains("日")) {
            if (str.indexOf("年") < 4 || str.indexOf("月") <= str.indexOf("年") || str.indexOf("日") != str.indexOf("月") + 2 && str.indexOf("日") != str.indexOf("月") + 3 && str.indexOf("日") != str.indexOf("月") + 4) {
                date = null;
            } else {
                String year = str.substring(str.indexOf("年") - 4, str.indexOf("年"));
                String month = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                String day = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                date = year + "年" + month + "月" + day + "日";
            }
        }

        return date;
    }
}
