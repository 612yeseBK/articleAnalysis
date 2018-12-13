package handler.baseModelHandler;

import model.WssscyrModel;
import service.impl.WsAnalyseImpl;
import util.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:诉讼参与人
 * Created by gaoyw on 2018/12/13.
 */
public class SscyrModelHandler {
    public SscyrModelHandler() {
    }

    public List<WssscyrModel> jxWssscyrModelList(List<String> sscyr, String ssjl) {
        List<WssscyrModel> wssscyrModellist = new ArrayList();
        String dt = "";
        String wdt = "";
        if (ssjl != null) {
            ArrayList<String> ssjlfd = WsAnalyseImpl.getWholeContent(ssjl);

            for(int i = 0; i < ssjlfd.size(); ++i) {
                if (((String)ssjlfd.get(i)).contains("未到庭") || ((String)ssjlfd.get(i)).contains("没有到庭")) {
                    wdt = (String)ssjlfd.get(i);
                    break;
                }

                if (((String)ssjlfd.get(i)).contains("到庭")) {
                    dt = (String)ssjlfd.get(i);
                    break;
                }
            }
        }

        for(int i = 0; i < sscyr.size(); ++i) {
            WssscyrModel wssscyrModel = new WssscyrModel();
            ArrayList<String> contentlist = WsAnalyseImpl.getWholeContent((String)sscyr.get(i));
            String sscyrallinfo = "";

            String ysssdw;
            for(Iterator var10 = contentlist.iterator(); var10.hasNext(); sscyrallinfo = sscyrallinfo + ysssdw) {
                ysssdw = (String)var10.next();
            }

            wssscyrModel.setSscyrallinfo(sscyrallinfo);
            String content = (String)contentlist.get(0);
            ysssdw = null;
            ysssdw = WsAnalyseImpl.takeBracket(content);
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

            String bssssf = HeadEnum.getHead(WsAnalyseImpl.deBracket(content));
            String sssf = bssssf;
            if (ysssdw != null) {
                sssf = bssssf + "（" + ysssdw + "）";
            }

            String temp;
            if (sssf != null) {
                wssscyrModel.setSssf(sssf);
                content = WsAnalyseImpl.deBracket(content);
                int index = content.indexOf(bssssf);
                temp = content.substring(index + bssssf.length(), content.length());
                if (temp.contains("：")) {
                    temp = temp.replaceFirst("：", "");
                }

                wssscyrModel.setSscyr(temp);
                if (dt != "" && dt.contains(temp)) {
                    wssscyrModel.setDtqk("到庭");
                }

                if (wdt != "" && wdt.contains(temp)) {
                    wssscyrModel.setDtqk("未到庭");
                }

                if (FcUtil.getWholeToken(temp).size() > 3) {
                    wssscyrModel.setDsrlx("法人");
                } else {
                    wssscyrModel.setDsrlx("自然人");
                }
            }

            if (StringUtil.contains(bssssf, "上诉人") || StringUtil.contains(bssssf, "被上诉人")) {
                wssscyrModel.setSsdw(bssssf);
            }

            if (ysssdw != null) {
                temp = ysssdw;
                if (ysssdw.contains("原审")) {
                    ysssdw = ysssdw.substring(ysssdw.indexOf("原审") + 2, ysssdw.indexOf("原审") + 4);
                } else if (ysssdw.contains("一审")) {
                    ysssdw = ysssdw.substring(ysssdw.indexOf("一审") + 2, ysssdw.indexOf("一审") + 4);
                }

                if (ysssdw.contains("第三")) {
                    ysssdw = "第三人";
                }

                if (ysssdw.contains("起诉")) {
                    ysssdw = "原告";
                }

                if (ysssdw.contains("本诉")) {
                    ysssdw = temp.substring(temp.indexOf("本诉") + 2, temp.indexOf("本诉") + 4);
                }

                wssscyrModel.setYsssdw(ysssdw);
            }

            temp = null;
            String[] dlr = new String[]{"法定代理人", "委托代理人", "法定代表人", "责任人", "第三人"};
            int j;
            if (bssssf != null) {
                if (bssssf.equals("上诉人")) {
                    temp = "上诉";
                } else if (bssssf.equals("被上诉人")) {
                    temp = "被上诉人";
                }

                for(j = 0; j < dlr.length; ++j) {
                    if (temp != null && temp.equals(dlr[j])) {
                        temp = "代理人";
                    }
                }
            }

            wssscyrModel.setDsrlb(temp);

            for(j = 1; j < contentlist.size(); ++j) {
                String zjlx = null;
                String zjhm = null;
                int rq;
                Pattern pattern;
                Matcher match;
                if (((String)contentlist.get(j)).indexOf("身份") != -1) {
                    zjlx = "身份证";
                    pattern = Pattern.compile("\\d{18}|\\d{17}(\\d|X|x)");

                    for(match = pattern.matcher((CharSequence)contentlist.get(j)); match.find(); zjhm = match.group()) {
                        ;
                    }
                } else if (((String)contentlist.get(j)).indexOf("执业证") == -1) {
                    if (((String)contentlist.get(j)).indexOf("护照") != -1) {
                        zjlx = "护照";
                        pattern = Pattern.compile("[a-zA-Z0-9]{5,17}");

                        for(match = pattern.matcher((CharSequence)contentlist.get(j)); match.find(); zjhm = match.group()) {
                            ;
                        }
                    }
                } else {
                    zjlx = "执业证";
                    ArrayList<String> zjxx = (ArrayList)FcUtil.getWholeToken((String)contentlist.get(j));
                    pattern = Pattern.compile("\\d");

                    for(int k = 0; k < zjxx.size(); ++k) {
                        rq = 0;

                        for(match = pattern.matcher((CharSequence)zjxx.get(k)); match.find(); ++rq) {
                            ;
                        }

                        if (rq >= 14) {
                            zjhm = (String)zjxx.get(k);
                        }
                    }
                }

                if (zjlx != null) {
                    wssscyrModel.setZjlx(zjlx);
                }

                String dsrdz = null;
                if (((String)contentlist.get(j)).indexOf("住所地") != -1 && ((String)contentlist.get(j)).indexOf("住所地") < 3) {
                    dsrdz = ((String)contentlist.get(j)).substring(((String)contentlist.get(j)).indexOf("住所地") + 3, ((String)contentlist.get(j)).length());
                } else if (((String)contentlist.get(j)).indexOf("住") != -1 && ((String)contentlist.get(j)).indexOf("住") < 3) {
                    dsrdz = ((String)contentlist.get(j)).substring(((String)contentlist.get(j)).indexOf("住") + 1, ((String)contentlist.get(j)).length());
                }

                String xb = null;
                if (((String)contentlist.get(j)).indexOf("男") != -1 && ((String)contentlist.get(j)).length() < 4) {
                    xb = "男";
                } else if (((String)contentlist.get(j)).indexOf("女") != -1 && ((String)contentlist.get(j)).length() < 4) {
                    xb = "女";
                }

                String csrq = null;
                rq = 0;
                if (((String)contentlist.get(j)).indexOf("年") != -1) {
                    ++rq;
                }

                if (((String)contentlist.get(j)).indexOf("月") != -1) {
                    ++rq;
                }

                if (((String)contentlist.get(j)).indexOf("日") != -1) {
                    ++rq;
                }

                if (((String)contentlist.get(j)).indexOf("生") != -1) {
                    ++rq;
                }

                if (rq == 4 && ((String)contentlist.get(j)).indexOf("年") - 3 > 0 && ((String)contentlist.get(j)).indexOf("年") > 3) {
                    csrq = ((String)contentlist.get(j)).substring(((String)contentlist.get(j)).indexOf("年") - 4, ((String)contentlist.get(j)).indexOf("日") + 1);
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
                if (FcUtil.getWholeToken((String)contentlist.get(j)).size() < 3) {
                    mz = MZEnum.getMZ((String)contentlist.get(j));
                }

                String dsrzw = null;
                if (FcUtil.getWholeToken((String)contentlist.get(j)).size() < 3) {
                    dsrzw = ZWEnum.getZW((String)contentlist.get(j));
                } else {
                    dsrzw = ZWEnum.getZW((String)contentlist.get(j));
                }

                String dsrwhcd = null;
                if (FcUtil.getWholeToken((String)contentlist.get(j)).size() < 3) {
                    dsrwhcd = WhcdEnum.getWhcd((String)contentlist.get(j));
                }

                if (dsrdz != null) {
                    if (dsrdz.contains("：")) {
                        dsrdz = dsrdz.replaceFirst("：", "");
                    }

                    wssscyrModel.setDsrdz(dsrdz);
                }

                if (xb != null) {
                    wssscyrModel.setXb(xb);
                }

                if (csrq != null) {
                    wssscyrModel.setCsrq(csrq);
                }

                if (zjhm != null) {
                    wssscyrModel.setZjhm(zjhm);
                }

                if (mz != null) {
                    wssscyrModel.setMz(mz);
                }

                if (dsrzw != null) {
                    wssscyrModel.setDsrzw(dsrzw);
                }

                if (year != null && month != null && day != null) {
                    wssscyrModel.setYear(year);
                    wssscyrModel.setMonth(month);
                    wssscyrModel.setDay(day);
                }
            }

            this.setDsrgj(wssscyrModel);
            setDwxz(wssscyrModel);
            wssscyrModellist.add(wssscyrModel);
        }

        setFddbr(wssscyrModellist);
        return wssscyrModellist;
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

    public static void setDwxz(WssscyrModel wssscyrModel) {
        String name = wssscyrModel.getSscyr();
        if (name != null && name.indexOf("股份有限公司") > -1) {
            wssscyrModel.setDwxz("股份有限公司");
        } else if (name == null || name.indexOf("有限责任公司") <= -1 && name.indexOf("有限公司") <= -1) {
            if (name != null && name.endsWith("公司")) {
                wssscyrModel.setDwxz("有限责任公司");
            } else if (name == null || name.indexOf("律师事务所") <= -1 && !name.endsWith("医院")) {
                if (name != null && (name.endsWith("厂") || name.endsWith("商行") || name.endsWith("法律事务所") || name.endsWith("运输队"))) {
                    wssscyrModel.setDwxz("企业");
                }
            } else {
                wssscyrModel.setDwxz("事业单位");
            }
        } else {
            wssscyrModel.setDwxz("有限责任公司");
        }

    }

    public static void setFddbr(List<WssscyrModel> wssscyrModellist) {
        int ssfIndex = -1;
        int ysfIndex = -1;
        boolean ssf = false;
        boolean ysf = false;

        String ysfDbr;
        for(int i = 0; i < wssscyrModellist.size(); ++i) {
            ysfDbr = ((WssscyrModel)wssscyrModellist.get(i)).getSssf();
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

        for(int i = 0; i < wssscyrModellist.size(); ++i) {
            if (ssfIndex == -1 || !StringUtil.equals(((WssscyrModel)wssscyrModellist.get(i)).getSssf(), "法定代表人") || i >= ysfIndex && ysfIndex != -1) {
                if (ysfIndex != -1 && StringUtil.equals(((WssscyrModel)wssscyrModellist.get(i)).getSssf(), "法定代表人") && i > ysfIndex) {
                    ysfDbr = ((WssscyrModel)wssscyrModellist.get(i)).getSscyr();
                    ((WssscyrModel)wssscyrModellist.get(i)).setGzdw(((WssscyrModel)wssscyrModellist.get(ysfIndex)).getSscyr());
                    ((WssscyrModel)wssscyrModellist.get(i)).setGzdwxz(((WssscyrModel)wssscyrModellist.get(ysfIndex)).getDwxz());
                }
            } else {
                ssfDbr = ((WssscyrModel)wssscyrModellist.get(i)).getSscyr();
                ((WssscyrModel)wssscyrModellist.get(i)).setGzdw(((WssscyrModel)wssscyrModellist.get(ssfIndex)).getSscyr());
                ((WssscyrModel)wssscyrModellist.get(i)).setGzdwxz(((WssscyrModel)wssscyrModellist.get(ssfIndex)).getDwxz());
            }
        }

        if (ssfIndex != -1 && !StringUtil.isBlank(ssfDbr)) {
            ((WssscyrModel)wssscyrModellist.get(ssfIndex)).setFddbr(ssfDbr);
        }

        if (ysfIndex != -1 && !StringUtil.isBlank(ysfDbr)) {
            ((WssscyrModel)wssscyrModellist.get(ysfIndex)).setFddbr(ysfDbr);
        }

    }
}
