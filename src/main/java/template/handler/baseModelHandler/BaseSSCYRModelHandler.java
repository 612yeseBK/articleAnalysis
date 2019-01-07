package template.handler.baseModelHandler;

import template.model.BaseModel.BaseSSCYRQJModel;
import template.model.another.WssscyrModel;
import template.service.impl.BaseWsAnalyseImpl;
import template.util.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:诉讼参与人
 * Created by gaoyw on 2018/12/13.
 */
public class BaseSSCYRModelHandler {
    public BaseSSCYRModelHandler() {
    }

//    public static void setDwxz(WssscyrModel wssscyrModel) {
//        String name = wssscyrModel.getSscyr();
//        if (name != null && name.indexOf("股份有限公司") > -1) {
//            wssscyrModel.setDwxz("股份有限公司");
//        } else if (name == null || name.indexOf("有限责任公司") <= -1 && name.indexOf("有限公司") <= -1) {
//            if (name != null && name.endsWith("公司")) {
//                wssscyrModel.setDwxz("有限责任公司");
//            } else if (name == null || name.indexOf("律师事务所") <= -1 && !name.endsWith("医院")) {
//                if (name != null && (name.endsWith("厂") || name.endsWith("商行") || name.endsWith("法律事务所") || name.endsWith("运输队"))) {
//                    wssscyrModel.setDwxz("企业");
//                }
//            } else {
//                wssscyrModel.setDwxz("事业单位");
//            }
//        } else {
//            wssscyrModel.setDwxz("有限责任公司");
//        }
//
//    }

    public static void setFddbr(List<WssscyrModel> wssscyrModellist) {
        int ssfIndex = -1;
        int ysfIndex = -1;
        boolean ssf = false;
        boolean ysf = false;

        String ysfDbr;
        for (int i = 0; i < wssscyrModellist.size(); ++i) {
            ysfDbr = (wssscyrModellist.get(i)).getSssf();
            if (!ssf && StringUtil.indexOf(ysfDbr, "上诉人") == 0) {
                ssfIndex = i;
                ssf = true;
            }

            if (!ysf && StringUtil.indexOf(ysfDbr, "被上诉人") == 0) {
                ysfIndex = i;
                ysf = true;
            }
        }

        String ssfDbr = "";
        ysfDbr = "";

        for (int i = 0; i < wssscyrModellist.size(); ++i) {
            if (ssfIndex == -1 || !StringUtil.equals(( wssscyrModellist.get(i)).getSssf(), "法定代表人") || i >= ysfIndex && ysfIndex != -1) {
                if (ysfIndex != -1 && StringUtil.equals((wssscyrModellist.get(i)).getSssf(), "法定代表人") && i > ysfIndex) {
                    ysfDbr = ( wssscyrModellist.get(i)).getSscyr();
                    ( wssscyrModellist.get(i)).setGzdw(( wssscyrModellist.get(ysfIndex)).getSscyr());
                    ( wssscyrModellist.get(i)).setGzdwxz((wssscyrModellist.get(ysfIndex)).getDwxz());
                }
            } else {
                ssfDbr = (wssscyrModellist.get(i)).getSscyr();
                ( wssscyrModellist.get(i)).setGzdw(( wssscyrModellist.get(ssfIndex)).getSscyr());
                ( wssscyrModellist.get(i)).setGzdwxz(( wssscyrModellist.get(ssfIndex)).getDwxz());
            }
        }

        if (ssfIndex != -1 && !StringUtil.isBlank(ssfDbr)) {
            (wssscyrModellist.get(ssfIndex)).setFddbr(ssfDbr);
        }

        if (ysfIndex != -1 && !StringUtil.isBlank(ysfDbr)) {
            ( wssscyrModellist.get(ysfIndex)).setFddbr(ysfDbr);
        }

    }

    public BaseSSCYRQJModel jxWssscyrModelList(List<String> sscyr, String ssjl) {
        BaseSSCYRQJModel baseSSCYRQJModel = new BaseSSCYRQJModel();
        String dt = "";
        String wdt = "";
        if (ssjl != null) {
            ArrayList<String> ssjlfd = BaseWsAnalyseImpl.getWholeContent(ssjl);

            for (int i = 0; i < ssjlfd.size(); ++i) {
                if (( ssjlfd.get(i)).contains("未到庭") || (ssjlfd.get(i)).contains("没有到庭")) {
                    wdt = ssjlfd.get(i);
                    break;
                }

                if ((ssjlfd.get(i)).contains("到庭")) {
                    dt = ssjlfd.get(i);
                    break;
                }
            }
        }

        for (int i = 0; i < sscyr.size(); ++i) {
            WssscyrModel wssscyrModel = new WssscyrModel();
            BaseSSCYRQJModel.SSCYR sscyr1 = new BaseSSCYRQJModel().new SSCYR();
            ArrayList<String> contentlist = BaseWsAnalyseImpl.getWholeContent(sscyr.get(i));
            String sscyrallinfo = "";

            String ysssdw;
            for (Iterator iterator = contentlist.iterator(); iterator.hasNext(); sscyrallinfo = sscyrallinfo + ysssdw) {
                ysssdw = (String) iterator.next();
            }

            wssscyrModel.setSscyrallinfo(sscyrallinfo);
            String content = contentlist.get(0);
            ysssdw = BaseWsAnalyseImpl.takeBracket(content);
            if (ysssdw != null) {
                if (!HeadEnum.HasHead(ysssdw)) {
                    ysssdw = null;
                } else if (ysssdw.contains("系")) {
                    ysssdw = null;
                } else if (ysssdw.contains("女婿")) {
                    ysssdw = null;
                } else if (ysssdw.contains("子")) {
                    ysssdw = null;
                }
            }

            String bssssf = HeadEnum.getHead(BaseWsAnalyseImpl.deBracket(content));
            String sssf = bssssf;
            if (ysssdw != null) {
                sssf = bssssf + "（" + ysssdw + "）";
            }

            String temp;
            if (sssf != null) {
                sscyr1.setSssf(sssf);
                content = BaseWsAnalyseImpl.deBracket(content);
                int index = content.indexOf(bssssf);
                temp = content.substring(index + bssssf.length(), content.length());
                if (temp.contains("：")) {
                    temp = temp.replaceFirst("：", "");
                }
                sscyr1.setSscyrmc(temp);
                if (dt != "" && dt.contains(temp)) {
                    sscyr1.setDtqk("到庭");
                }

                if (wdt != "" && wdt.contains(temp)) {
                    sscyr1.setDtqk("未到庭");
                }

                if (FcUtil.getWholeToken(temp).size() > 3) {
                    sscyr1.setDsrlx("法人");
                } else {
                    sscyr1.setDsrlx("自然人");
                }
            }

            if (StringUtil.contains(bssssf, "上诉人") || StringUtil.contains(bssssf, "被上诉人")) {
                sscyr1.setSsdw(bssssf);
            }

//            if (ysssdw != null) {
//                temp = ysssdw;
//                if (ysssdw.contains("原审")) {
//                    ysssdw = ysssdw.substring(ysssdw.indexOf("原审") + 2, ysssdw.indexOf("原审") + 4);
//                } else if (ysssdw.contains("一审")) {
//                    ysssdw = ysssdw.substring(ysssdw.indexOf("一审") + 2, ysssdw.indexOf("一审") + 4);
//                }

//                if (ysssdw.contains("第三")) {
//                    ysssdw = "第三人";
//                }
//
//                if (ysssdw.contains("起诉")) {
//                    ysssdw = "原告";
//                }
//
//                if (ysssdw.contains("本诉")) {
//                    ysssdw = temp.substring(temp.indexOf("本诉") + 2, temp.indexOf("本诉") + 4);
//                }

//                wssscyrModel.setYsssdw(ysssdw);
//            }

            temp = null;
            String[] dlr = new String[]{"法定代理人", "委托代理人", "法定代表人", "责任人", "第三人"};
            int j;
            if (bssssf != null) {
                if (bssssf.equals("上诉人")) {
                    temp = "上诉";
                } else if (bssssf.equals("被上诉人")) {
                    temp = "被上诉人";
                }

                for (j = 0; j < dlr.length; ++j) {
                    if (temp != null && temp.equals(dlr[j])) {
                        temp = "代理人";
                    }
                }
            }

            wssscyrModel.setDsrlb(temp);

            for (j = 1; j < contentlist.size(); ++j) {
//                String zjlx = null;
//                String zjhm = null;
                int rq;
//                Pattern pattern;
//                Matcher match;
//                if ((contentlist.get(j)).indexOf("身份") != -1) {
//                    zjlx = "身份证";
//                    pattern = Pattern.compile("\\d{18}|\\d{17}(\\d|X|x)");
//
//                    for (match = pattern.matcher((CharSequence) contentlist.get(j)); match.find(); zjhm = match.group()) {
//                        ;
//                    }
//                } else if (( contentlist.get(j)).indexOf("执业证") == -1) {
//                    if ((contentlist.get(j)).indexOf("护照") != -1) {
//                        zjlx = "护照";
//                        pattern = Pattern.compile("[a-zA-Z0-9]{5,17}");
//
//                        for (match = pattern.matcher(contentlist.get(j)); match.find(); zjhm = match.group()) {
//                            ;
//                        }
//                    }
//                } else {
//                    zjlx = "执业证";
//                    ArrayList<String> zjxx = (ArrayList) FcUtil.getWholeToken((String) contentlist.get(j));
//                    pattern = Pattern.compile("\\d");
//
//                    for (int k = 0; k < zjxx.size(); ++k) {
//                        rq = 0;
//
//                        for (match = pattern.matcher((CharSequence) zjxx.get(k)); match.find(); ++rq) {
//                            ;
//                        }
//
//                        if (rq >= 14) {
//                            zjhm = (String) zjxx.get(k);
//                        }
//                    }
//                }

//                if (zjlx != null) {
//                    wssscyrModel.setZjlx(zjlx);
//                }

                String dsrdz = null;
                if (((String) contentlist.get(j)).indexOf("住所地") != -1 && (contentlist.get(j)).indexOf("住所地") < 3) {
                    dsrdz = ( contentlist.get(j)).substring((contentlist.get(j)).indexOf("住所地") + 3, (contentlist.get(j)).length());
                } else if ((contentlist.get(j)).indexOf("住") != -1 && (contentlist.get(j)).indexOf("住") < 3) {
                    dsrdz = (contentlist.get(j)).substring((contentlist.get(j)).indexOf("住") + 1, (contentlist.get(j)).length());
                }

                String xb = null;
                if ((contentlist.get(j)).indexOf("男") != -1 && (contentlist.get(j)).length() < 4) {
                    xb = "男";
                } else if ((contentlist.get(j)).indexOf("女") != -1 && (contentlist.get(j)).length() < 4) {
                    xb = "女";
                }

                String csrq = null;
                rq = 0;
                if ((contentlist.get(j)).indexOf("年") != -1) {
                    ++rq;
                }

                if ((contentlist.get(j)).indexOf("月") != -1) {
                    ++rq;
                }

                if ((contentlist.get(j)).indexOf("日") != -1) {
                    ++rq;
                }

                if ((contentlist.get(j)).indexOf("生") != -1) {
                    ++rq;
                }

                if (rq == 4 && (contentlist.get(j)).indexOf("年") - 3 > 0 && (contentlist.get(j)).indexOf("年") > 3) {
                    csrq = (contentlist.get(j)).substring((contentlist.get(j)).indexOf("年") - 4, (contentlist.get(j)).indexOf("日") + 1);
                }

                String year = null;
                String month = null;
                String day = null;
                if (csrq != null) {
                    year = csrq.substring(csrq.indexOf("年") - 4, csrq.indexOf("年"));
                    month = csrq.substring(csrq.indexOf("年") + 1, csrq.indexOf("月"));
                    day = csrq.substring(csrq.indexOf("月") + 1, csrq.indexOf("日"));
                }

                String mz = null;
                if (FcUtil.getWholeToken(contentlist.get(j)).size() < 3) {
                    mz = MZEnum.getMZ(contentlist.get(j));
                }

                if (dsrdz != null) {
                    if (dsrdz.contains("：")) {
                        dsrdz = dsrdz.replaceFirst("：", "");
                    }
                    sscyr1.setDsrdz(dsrdz);
                }

                if (xb != null) {
                    sscyr1.setXb(xb);
                }

                if (csrq != null) {
                    sscyr1.setCsrq(csrq);
                }

                if (mz != null) {
                    sscyr1.setMz(mz);
                }

                if (year != null && month != null && day != null) {
                    wssscyrModel.setYear(year);
                    wssscyrModel.setMonth(month);
                    wssscyrModel.setDay(day);
                }
            }

            this.setDsrgj(wssscyrModel);
            baseSSCYRQJModel.getSSCYRQJ().add(sscyr1);
        }

        return baseSSCYRQJModel;
    }

    private void setDsrgj(WssscyrModel wssscyrModel) {
        String dsrgj = null;
        String dsrmc = wssscyrModel.getSscyr();
        String allinfo = wssscyrModel.getSscyrallinfo();
        if (allinfo.contains("澳门") && allinfo.contains("居民")) {
            dsrgj = "中国澳门";
        } else if (allinfo.contains("香港") && allinfo.contains("居民")) {
            dsrgj = "中国香港";
        } else if (allinfo.contains("加拿大") && allinfo.contains("国籍")) {
            dsrgj = "加拿大";
        } else if (allinfo.contains("美利坚合众国") && allinfo.contains("国籍") || allinfo.contains("美国籍") || allinfo.contains("美利坚") && allinfo.contains("公民")) {
            dsrgj = "美国";
        } else if (allinfo.contains("大韩民国") && allinfo.contains("公民")) {
            dsrgj = "韩国";
        } else if (allinfo.contains("新西兰") && allinfo.contains("国籍")) {
            dsrgj = "新西兰";
        } else if (allinfo.contains("澳大利亚") && allinfo.contains("公民")) {
            dsrgj = "澳大利亚";
        } else if (dsrmc != null && dsrmc.length() < 5) {
            dsrgj = "中国";
        }

        wssscyrModel.setGj(dsrgj);
    }
}
