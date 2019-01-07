package template.handler.baseModelHandler;

import template.model.BaseModel.BaseCPJGModel;
import template.model.BaseModel.BaseSSCYRQJModel;
import template.model.another.*;
import template.service.impl.BaseWsAnalyseImpl;
import template.util.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public class BaseCPJGModelHandler {
    public BaseCPJGModelHandler() {
    }

    public BaseCPJGModel jxWscpjgModel(BaseWsAnalyseImpl wsAnalyse, BaseSSCYRQJModel baseSSCYRQJModel, AjlxEnum ajlxEnum) {
//        List<WssscyrModel> wssscyrModellist = new ArrayList<>();
        BaseCPJGModel baseCPJGModel = new BaseCPJGModel();
//        List<String> cpjg = wsAnalyse.getCpjg();
//        WscpjgModel wscpjgModel = new WscpjgModel();
//        List<String> cpjgnrList = new ArrayList();
//        List<PjjgnrModel> pjjgList = new ArrayList();
//        String pjjgnr = "";
//        String allnr = "";
//        boolean cpjgnrFlag = true;
//        List<String> pjjelx = getPjjeLx();
//
//        int j;
//        for(j = 0; j < cpjg.size(); ++j) {
//            allnr = allnr + (String)cpjg.get(j);
//            if (cpjgnrFlag && !isAjslf((String)cpjg.get(j))) {
//                cpjgnrList.add(cpjg.get(j));
//                pjjgList.add(new PjjgnrModel((String)cpjg.get(j)));
//                pjjgnr = pjjgnr + (String)cpjg.get(j);
//            } else {
//                cpjgnrFlag = false;
//            }
//
//            if (isAjslf((String)cpjg.get(j))) {
//                if (StringUtil.isBlank(wscpjgModel.getAjslf())) {
//                    wscpjgModel.setAjslf((String)cpjg.get(j));
//                } else {
//                    wscpjgModel.setAjslf(wscpjgModel.getAjslf() + (String)cpjg.get(j));
//                }
//
//                cpjgnrFlag = false;
//            }
//
//            if (StringUtil.contains(ajlxEnum.getAjlx(), "一审") && ((String)cpjg.get(j)).indexOf("如不服本") > -1) {
//                setSsqk(wscpjgModel, (String)cpjg.get(j));
//            }
//
//            if (pjjgnr.contains("准") && (pjjgnr.contains("撤回起诉") || pjjgnr.contains("撤诉申请") || pjjgnr.contains("撤诉") || pjjgnr.contains("撤回") && (pjjgnr.contains("诉讼") || pjjgnr.contains("起诉")))) {
//                setCsrjh(wscpjgModel, wssscyrModellist, (String)cpjg.get(j), wsAnalyse);
//            }
//        }
//
//        if (StringUtil.contains(ajlxEnum.getAjlx(), "民事一审") || StringUtil.contains(ajlxEnum.getAjlx(), "民事二审")) {
//            Iterator var17 = pjjgList.iterator();
//
//            while(var17.hasNext()) {
//                PjjgnrModel pjjgnrmodel = (PjjgnrModel)var17.next();
//                setQlywr(pjjgnrmodel, wssscyrModellist);
//                setPjzxqx(pjjgnrmodel);
//                setPjje(pjjgnrmodel, pjjelx);
//            }
//
//            wscpjgModel.setPjjgList(pjjgList);
//        }
//
//        setSsfcd(wscpjgModel, wssscyrModellist);
//        wscpjgModel = setJabdje(wscpjgModel);
//        wscpjgModel = setJafsByAjlx(wscpjgModel, pjjgnr, allnr, ajlxEnum, wsAnalyse);
//        wscpjgModel.setSffhcs(StringUtil.equals(wscpjgModel.getSffhcs(), "是") ? "是" : "否");
//        String reg;
//        if (StringUtil.equals(wscpjgModel.getJafs(), "发回重审")) {
//            List<String> cpfxgc = wsAnalyse.getCpfxgc();
//            if (cpfxgc != null) {
//                Iterator var19 = cpfxgc.iterator();
//
//                while(var19.hasNext()) {
//                    reg = (String)var19.next();
//                    if (reg.contains("事实不清")) {
//                        wscpjgModel.setFhcsyy("原判决认定基本事实不清");
//                        break;
//                    }
//
//                    if (MsesFhcsyyEnum.getMsesfhccyy(reg) != null) {
//                        wscpjgModel.setFhcsyy(MsesFhcsyyEnum.getMsesfhccyy(reg));
//                        break;
//                    }
//
//                    wscpjgModel.setFhcsyy("其他");
//                }
//            }
//        }
//
//        if (StringUtil.contains(ajlxEnum.getAjlx(), "行政一审") || StringUtil.contains(ajlxEnum.getAjlx(), "民事一审")) {
//            setTcgxyy(wscpjgModel, allnr);
//        }
//
//        for(j = 0; j < cpjgnrList.size(); ++j) {
//            if (((String)cpjgnrList.get(j)).contains("驳回") && ((String)cpjgnrList.get(j)).contains("其他") && ((String)cpjgnrList.get(j)).contains("诉讼")) {
//                wscpjgModel.setSfzcssqq("部分支持部分不支持");
//            } else if (((String)cpjgnrList.get(j)).contains("驳回上诉")) {
//                wscpjgModel.setSfzcssqq("全部驳回");
//            } else if (((String)cpjgnrList.get(j)).contains("被告") && ((String)cpjgnrList.get(j)).contains("违法")) {
//                wscpjgModel.setSfzcssqq("全部支持");
//            }
//
//            if (wscpjgModel.getSfzcssqq() != "部分支持部分不支持" && wscpjgModel.getSfzcssqq() != "全部支持") {
//                if (wscpjgModel.getSfzcssqq() == "全部驳回") {
//                    wscpjgModel.setSbsf("应诉方");
//                }
//            } else {
//                wscpjgModel.setSbsf("起诉方");
//            }
//        }
//
//        for(j = 0; j < cpjgnrList.size(); ++j) {
//            if (((String)cpjgnrList.get(j)).contains("被告") && ((String)cpjgnrList.get(j)).contains("赔偿") && ((String)cpjgnrList.get(j)).contains("付清")) {
//                wscpjgModel.setSfzcxzpc("是");
//                if (((String)cpjgnrList.get(j)).contains("元")) {
//                    String xzpcje = "";
//                    reg = "(\\d+(\\.\\d+)?)";
//                    Pattern p = Pattern.compile(reg);
//                    Matcher m = p.matcher((CharSequence)cpjgnrList.get(j));
//                    if (m.find()) {
//                        xzpcje = m.group() + "元";
//                        wscpjgModel.setXzpcje(xzpcje);
//                    }
//                }
//                break;
//            }
//
//            if (((String)cpjgnrList.get(j)).contains("驳回")) {
//                wscpjgModel.setSfzcxzpc("否");
//            }
//        }
//
//        PjjgService pjjgservice = new PjjgServiceImpl();
//        boolean sx = pjjgservice.isPeichangIndexCorrect(pjjgnr, wssscyrModellist);
//        if (sx) {
//            wscpjgModel.setPcsxsfzq("正确");
//        } else {
//            wscpjgModel.setPcsxsfzq("错误");
//        }
//
//        DsrbxgsService dsrService = new DsrbxgsServiceImpl();
//        if (dsrService.jqxBg(wssscyrModellist)) {
//            wscpjgModel.setBsgssfbg("正确");
//        } else {
//            wscpjgModel.setBsgssfbg("错误");
//        }

        return baseCPJGModel;
    }

//    public static WscpjgModel setJafsByAjlx(WscpjgModel wscpjgModel, String pjjgnr, String allPjjg, AjlxEnum ajlxEnum, WsAnalyseImpl wsAnalyse) {
//        if (StringUtil.contains(ajlxEnum.getAjlx(), "民事一审")) {
//            return setMsysjafs(wscpjgModel, pjjgnr, allPjjg, wsAnalyse);
//        } else if (StringUtil.contains(ajlxEnum.getAjlx(), "民事二审")) {
//            return setMsesjafs(wscpjgModel, pjjgnr);
//        } else if (StringUtil.contains(ajlxEnum.getAjlx(), "行政一审")) {
//            return setXzysjafs(wscpjgModel, pjjgnr, allPjjg, wsAnalyse);
//        } else {
//            return StringUtil.contains(ajlxEnum.getAjlx(), "行政二审") ? setXzesjafs(wscpjgModel, pjjgnr) : wscpjgModel;
//        }
//    }

    public static WscpjgModel setMsesjafs(WscpjgModel wscpjgModel, String pjjgnr) {
        if (!StringUtil.equals(pjjgnr, "")) {
            if (!pjjgnr.contains("撤销") && !pjjgnr.contains("变更") && pjjgnr.contains("维持")) {
                wscpjgModel.setJafs("维持");
            } else if (pjjgnr.contains("撤销") && pjjgnr.contains("驳回") && pjjgnr.contains("起诉")) {
                wscpjgModel.setJafs("撤销原判并驳回起诉");
            } else if (pjjgnr.contains("发回") && (pjjgnr.contains("重审") || pjjgnr.contains("重新审理"))) {
                wscpjgModel.setJafs("发回重审");
                wscpjgModel.setSffhcs("是");
            } else if (pjjgnr.contains("撤销") && pjjgnr.contains("裁定") && pjjgnr.contains("受理")) {
                wscpjgModel.setJafs("撤销原裁定并指令受理");
            } else if (pjjgnr.contains("撤销") && pjjgnr.contains("裁定") && pjjgnr.contains("审理")) {
                wscpjgModel.setJafs("撤销原裁定并指令审理");
            } else if (pjjgnr.contains("调解")) {
                wscpjgModel.setJafs("调解");
            } else if (pjjgnr.contains("撤销") && pjjgnr.contains("判决") && (pjjgnr.contains("准许") || pjjgnr.contains("准允")) && pjjgnr.contains("撤回起诉")) {
                wscpjgModel.setJafs("准予撤回起诉并撤销一审判决");
            } else if (!pjjgnr.contains("准许") && !pjjgnr.contains("准允") && !pjjgnr.contains("准予") || !pjjgnr.contains("撤回上诉") && !pjjgnr.contains("撤回诉讼")) {
                if (pjjgnr.contains("按") && (pjjgnr.contains("撤诉") || pjjgnr.contains("撤回上诉")) && pjjgnr.contains("处理")) {
                    wscpjgModel.setJafs("按撤回上诉处理");
                } else if (pjjgnr.contains("维持") && (pjjgnr.contains("撤销") || pjjgnr.contains("变更")) || pjjgnr.contains("撤销") && pjjgnr.contains("驳回") && pjjgnr.contains("诉讼请求")) {
                    wscpjgModel.setJafs("改判");
                } else if (pjjgnr.contains("终结诉讼")) {
                    wscpjgModel.setJafs("终结");
                } else if (pjjgnr.contains("中止诉讼")) {
                    wscpjgModel.setJafs("其他");
                }
            } else {
                wscpjgModel.setJafs("准予撤回上诉");
            }

            if (StringUtil.isBlank(wscpjgModel.getJafs())) {
                wscpjgModel.setJafs("其他");
            }
        }

        return wscpjgModel;
    }

    public static WscpjgModel setMsysjafs(WscpjgModel wscpjgModel, String pjjgnr, String allPjjg, BaseWsAnalyseImpl wsAnalyse) {
        if (!StringUtil.equals(pjjgnr, "")) {
            List<String> cpfxgc = wsAnalyse.getCpfxgc();
            String cpfxgcStr = "";
            String s;
            if (cpfxgc != null) {
                for(Iterator var6 = cpfxgc.iterator(); var6.hasNext(); cpfxgcStr = cpfxgcStr + s) {
                    s = (String)var6.next();
                }
            }

            String wsStr = "";
//            String s = null;
            if (wsAnalyse.getWs() != null && wsAnalyse.getWs().size() > 0) {
                for(Iterator var10 = wsAnalyse.getWs().iterator(); var10.hasNext(); wsStr = wsStr + s) {
                    s = (String)var10.next();
                }
            }

            if (!pjjgnr.contains("准") || !pjjgnr.contains("撤回起诉") && !pjjgnr.contains("撤诉申请") && !pjjgnr.contains("撤诉") && (!pjjgnr.contains("撤回") || !pjjgnr.contains("诉讼") && !pjjgnr.contains("起诉"))) {
                if (pjjgnr.contains("驳回") && pjjgnr.contains("起诉")) {
                    wscpjgModel.setJafs("驳回起诉");
                } else if (pjjgnr.contains("不予受理")) {
                    wscpjgModel.setJafs("不予受理");
                } else if (pjjgnr.contains("按") && pjjgnr.contains("撤诉处理")) {
                    wscpjgModel.setJafs("按撤诉处理");
                } else if (!pjjgnr.contains("移送") || !pjjgnr.contains("法院") || !pjjgnr.contains("管辖") && !pjjgnr.contains("处理") && !pjjgnr.contains("审理")) {
                    if (!pjjgnr.contains("不予登记") && !pjjgnr.contains("不予立案")) {
                        if (cpfxgc != null && StringUtil.contains(cpfxgcStr, "调解") && StringUtil.contains(cpfxgcStr, "达成") && StringUtil.contains(cpfxgcStr, "如下协议")) {
                            wscpjgModel.setJafs("调解");
                        } else if (!allPjjg.contains("判决") && !StringUtil.contains(cpfxgcStr, "判决如下")) {
                            if (StringUtil.contains(wsStr, "调解书")) {
                                wscpjgModel.setJafs("调解");
                            }
                        } else {
                            wscpjgModel.setJafs("判决");
                        }
                    } else {
                        wscpjgModel.setJafs("不予登记立案");
                    }
                } else {
                    wscpjgModel.setJafs("裁定移送其他法院管辖");
                }
            } else {
                wscpjgModel.setJafs("准予撤诉");
            }

            if (StringUtil.isBlank(wscpjgModel.getJafs())) {
                wscpjgModel.setJafs("其他");
            }
        }

        return wscpjgModel;
    }

//    public static WscpjgModel setXzysjafs(WscpjgModel wscpjgModel, String pjjgnr, String allPjjg, WsAnalyseImpl wsAnalyse) {
//        if (!StringUtil.equals(pjjgnr, "")) {
//            List<String> cpfxgc = wsAnalyse.getCpfxgc();
//            String cpfxgcStr = "";
//            String s;
//            if (cpfxgc != null) {
//                for(Iterator var6 = cpfxgc.iterator(); var6.hasNext(); cpfxgcStr = cpfxgcStr + s) {
//                    s = (String)var6.next();
//                }
//            }
//
//            if (!allPjjg.contains("判决") && !StringUtil.contains(cpfxgcStr, "判决如下")) {
//                if (!pjjgnr.contains("准") || !pjjgnr.contains("撤回起诉") && !pjjgnr.contains("撤诉申请") && !pjjgnr.contains("撤诉") && (!pjjgnr.contains("撤回") || !pjjgnr.contains("诉讼") && !pjjgnr.contains("起诉"))) {
//                    if (StringUtil.contains(cpfxgcStr, "判决如下") || !pjjgnr.contains("驳回") || !pjjgnr.contains("起诉") && !pjjgnr.contains("申请")) {
//                        if (!StringUtil.contains(cpfxgcStr, "判决如下") && (pjjgnr.contains("不予立案") || pjjgnr.contains("不予受理"))) {
//                            wscpjgModel.setJafs("不予立案");
//                        } else if (pjjgnr.contains("按") && pjjgnr.contains("撤诉处理")) {
//                            wscpjgModel.setJafs("按撤诉处理");
//                        } else if (!pjjgnr.contains("移送") || !pjjgnr.contains("法院") || !pjjgnr.contains("管辖") && !pjjgnr.contains("处理") && !pjjgnr.contains("审理")) {
//                            if (pjjgnr.contains("不予登记")) {
//                                wscpjgModel.setJafs("不予登记立案");
//                            } else if (cpfxgc != null && StringUtil.contains(cpfxgcStr, "调解") && StringUtil.contains(cpfxgcStr, "达成") && StringUtil.contains(cpfxgcStr, "协议") && !StringUtil.contains(cpfxgcStr, "判决如下")) {
//                                wscpjgModel.setJafs("调解");
//                            }
//                        } else {
//                            wscpjgModel.setJafs("裁定移送其他法院管辖");
//                        }
//                    } else {
//                        wscpjgModel.setJafs("驳回起诉");
//                    }
//                } else {
//                    wscpjgModel.setJafs("准予撤诉");
//                }
//            } else {
//                wscpjgModel.setJafs("判决");
//            }
//
//            if (StringUtil.isBlank(wscpjgModel.getJafs())) {
//                wscpjgModel.setJafs("其他");
//            }
//        }
//
//        return wscpjgModel;
//    }

    public static WscpjgModel setXzesjafs(WscpjgModel wscpjgModel, String pjjgnr) {
        if (!StringUtil.equals(pjjgnr, "")) {
            if (!pjjgnr.contains("撤销") && !pjjgnr.contains("变更") && pjjgnr.contains("维持")) {
                wscpjgModel.setJafs("维持");
            } else if (pjjgnr.contains("撤销") && pjjgnr.contains("驳回") && pjjgnr.contains("起诉")) {
                wscpjgModel.setJafs("撤销原判并驳回起诉");
            } else if (pjjgnr.contains("发回") && (pjjgnr.contains("重审") || pjjgnr.contains("重新审理"))) {
                wscpjgModel.setJafs("发回重审");
                wscpjgModel.setSffhcs("是");
            } else if (pjjgnr.contains("撤销") && pjjgnr.contains("裁定") && pjjgnr.contains("受理")) {
                wscpjgModel.setJafs("撤销原裁定并指令受理");
            } else if (pjjgnr.contains("撤销") && pjjgnr.contains("裁定") && pjjgnr.contains("审理")) {
                wscpjgModel.setJafs("撤销原裁定并指令审理");
            } else if (pjjgnr.contains("调解")) {
                wscpjgModel.setJafs("调解");
            } else if (pjjgnr.contains("撤销") && pjjgnr.contains("判决") && (pjjgnr.contains("准许") || pjjgnr.contains("准允")) && pjjgnr.contains("撤回起诉")) {
                wscpjgModel.setJafs("准予撤回起诉并撤销一审判决");
            } else if (!pjjgnr.contains("准许") && !pjjgnr.contains("准允") && !pjjgnr.contains("准予") || !pjjgnr.contains("撤回上诉") && !pjjgnr.contains("撤回诉讼")) {
                if (pjjgnr.contains("按") && (pjjgnr.contains("撤诉") || pjjgnr.contains("撤回上诉")) && pjjgnr.contains("处理")) {
                    wscpjgModel.setJafs("按撤回上诉处理");
                } else if (pjjgnr.contains("维持") && (pjjgnr.contains("撤销") || pjjgnr.contains("变更")) || pjjgnr.contains("撤销") && pjjgnr.contains("驳回") && pjjgnr.contains("诉讼请求")) {
                    wscpjgModel.setJafs("改判");
                } else if (pjjgnr.contains("终结诉讼")) {
                    wscpjgModel.setJafs("终结");
                }
            } else {
                wscpjgModel.setJafs("准予撤回上诉");
            }

            if (StringUtil.isBlank(wscpjgModel.getJafs())) {
                wscpjgModel.setJafs("其他");
            }
        }

        return wscpjgModel;
    }

    public static WscpjgModel setJabdje(WscpjgModel wscpjgModel) {
        List<String> pjjgList = wscpjgModel.getCpjgnr();
        List<String> jes = new ArrayList();
        if (pjjgList != null) {
            Iterator var3 = pjjgList.iterator();

            while(var3.hasNext()) {
                String jg = (String)var3.next();
                getJe(jg, jes, true);
            }
        }

        if (jes.size() > 0) {
            wscpjgModel.setJabde(jes);
        }

        Double zje = 0.0D;

        try {
            String s;
            for(Iterator var8 = jes.iterator(); var8.hasNext(); zje = zje.doubleValue() + Double.parseDouble(s)) {
                s = (String)var8.next();
            }

            if (zje.doubleValue() != 0.0D) {
                wscpjgModel.setJabdze(zje + "元");
            }
        } catch (Exception var6) {
            ;
        }

        return wscpjgModel;
    }

    public static List<String> getJe(String content, List<String> moneyList, boolean gjFlag) {
        String reg = "元";
        String[] nums = content.split(reg);

        for(int i = 0; i < nums.length; ++i) {
            int index = -1;
            char[] chars = nums[i].toCharArray();

            for(int j = chars.length - 1; j > -1; --j) {
                if (!Character.isDigit(nums[i].charAt(j)) && nums[i].charAt(j) != '．' && nums[i].charAt(j) != 19975 && nums[i].charAt(j) != '，') {
                    index = j;
                    break;
                }
            }

            String je_toAdd = StringUtil.ToDBC(nums[i].substring(index + 1, nums[i].length()));
            je_toAdd = je_toAdd.replaceAll(",", "");
            if (nums[i].indexOf("共计") != index - 1 && !StringUtil.isBlank(je_toAdd)) {
                if (je_toAdd.endsWith("万")) {
                    je_toAdd = je_toAdd.substring(0, je_toAdd.length() - 1);

                    try {
                        Double je_addDou = Double.parseDouble(je_toAdd) * 10000.0D;
                        je_toAdd = je_addDou + "";
                    } catch (Exception var10) {
                        je_toAdd = "";
                    }
                }

                if (!StringUtil.isBlank(je_toAdd)) {
                    moneyList.add(je_toAdd);
                }
            }
        }

        return moneyList;
    }

    public static boolean isAjslf(String content) {
        return content.indexOf("案件受理费") == 0 || content.indexOf("本案受理费") == 0 || content.indexOf("本案案件受理费") == 0 || content.indexOf("本案一审诉讼费") == 0 || content.indexOf("案件受理费") == 2 || content.indexOf("减半收取") > -1 || content.indexOf("案件诉讼费") == 0 || content.indexOf("诉讼费") == 0 || content.indexOf("本案诉讼费") == 0 || content.indexOf("本诉案件受理费") == 0 || content.indexOf("本案件受理费") == 0 || content.indexOf("一审案件受理费") == 0 || content.indexOf("案件一审受理费") == 0 || content.indexOf("本案一审案件受理费") == 0 || content.indexOf("一、二审案件受理费") > -1 || content.indexOf("一审案件诉讼费") > -1 || content.indexOf("一、二审案件诉讼费") > -1 || content.indexOf("二审案件受理费") == 0 || content.indexOf("案件二审受理费") == 0 || content.indexOf("本案二审案件受理费") == 0 || content.indexOf("本案二审受理费") == 0 || content.indexOf("本案第二审案件受理费") == 0 || content.indexOf("第二审案件受理费") == 0 || content.indexOf("二审受理费") == 0 || content.indexOf("上诉案件受理费") == 0 || content.indexOf("二审诉讼费") > -1 || content.indexOf("本系列案件二审案件受理费") == 0 || content.indexOf("公告费") > -1 || content.indexOf("本案收案件") > -1 || content.indexOf("本案减半征收案件") > -1;
    }

    public static boolean startWithNumber(String content) {
        return content.indexOf("一") == 0 || content.indexOf("二") == 0 || content.indexOf("三") == 0 || content.indexOf("四") == 0 || content.indexOf("五") == 0 || content.indexOf("六") == 0 || content.indexOf("七") == 0 || content.indexOf("八") == 0 || content.indexOf("九") == 0 || content.indexOf("十") == 0 || content.indexOf("1") == 0 || content.indexOf("2") == 0 || content.indexOf("3") == 0 || content.indexOf("4") == 0 || content.indexOf("5") == 0 || content.indexOf("6") == 0 || content.indexOf("7") == 0 || content.indexOf("8") == 0 || content.indexOf("9") == 0 || content.indexOf("10") == 0;
    }

    public static void setQlywr(PjjgnrModel pjjgnrModel, List<WssscyrModel> wssscyrModellist) {
        String pjjg = pjjgnrModel.getPjjgnr();
        HashMap<String, String> qlr = new HashMap();
        HashMap<String, String> ywr = new HashMap();
        int firstIndex = getMin(pjjg);
        HashMap<String, Integer> nameIndexMap = new HashMap();
        Iterator var7 = wssscyrModellist.iterator();

        while(var7.hasNext()) {
            WssscyrModel cyr = (WssscyrModel)var7.next();
            if (!StringUtil.isBlank(cyr.getSscyr())) {
                String name = cyr.getSscyr();
                int nameIndex = pjjg.indexOf(name);
                nameIndexMap.put(name, nameIndex);
            }
        }

        boolean flag = true;
        Iterator var14;
        if (firstIndex > -1 && firstIndex != pjjg.length()) {
            var14 = nameIndexMap.entrySet().iterator();

            while(var14.hasNext()) {
                Map.Entry<String, Integer> entry = (Map.Entry)var14.next();
                if (((Integer)entry.getValue()).intValue() > firstIndex) {
                    flag = false;
                    break;
                }
            }
        }

        if (!flag && firstIndex > -1 && firstIndex != pjjg.length()) {
            var14 = wssscyrModellist.iterator();

            while(true) {
                while(var14.hasNext()) {
                    WssscyrModel sscyr = (WssscyrModel)var14.next();
                    String name = sscyr.getSscyr();
                    int nameIndex = pjjg.indexOf(name);
                    if (nameIndex > -1 && nameIndex < firstIndex) {
                        ywr.put(name, sscyr.getSssf());
                    } else if (nameIndex > -1 && nameIndex > firstIndex) {
                        qlr.put(name, sscyr.getSssf());
                    }
                }

                pjjgnrModel.setQlr(qlr);
                pjjgnrModel.setYwr(ywr);
                break;
            }
        } else if (flag && firstIndex > -1 && firstIndex != pjjg.length()) {
            int qlIndex = -1;
            Iterator var17 = wssscyrModellist.iterator();

            String name;
            WssscyrModel sscyr;
            label80: {
                String ssdwname;
                do {
                    do {
                        do {
                            if (!var17.hasNext()) {
                                break label80;
                            }

                            sscyr = (WssscyrModel)var17.next();
                            name = sscyr.getSscyr();
                        } while(StringUtil.isBlank(name));

                        ssdwname = sscyr.getSssf() + sscyr.getSscyr();
                    } while(((Integer)nameIndexMap.get(name)).intValue() <= -1);
                } while(pjjg.indexOf("向" + name) <= 0 && pjjg.indexOf("向" + ssdwname) <= 0);

                qlr.put(name, sscyr.getSssf());
                qlIndex = ((Integer)nameIndexMap.get(name)).intValue();
            }

            if (qlIndex != -1) {
                var17 = wssscyrModellist.iterator();

                while(var17.hasNext()) {
                    sscyr = (WssscyrModel)var17.next();
                    name = sscyr.getSscyr();
                    if (!StringUtil.isBlank(name) && ((Integer)nameIndexMap.get(name)).intValue() > -1 && ((Integer)nameIndexMap.get(name)).intValue() < qlIndex) {
                        ywr.put(name, sscyr.getSssf());
                    }
                }
            }

            pjjgnrModel.setQlr(qlr);
            pjjgnrModel.setYwr(ywr);
        }

    }

    public static int getMin(String content) {
        List<Integer> indexList = new ArrayList();
        indexList.add(content.indexOf("赔偿"));
        indexList.add(content.indexOf("支付"));
        indexList.add(content.indexOf("承担"));
        indexList.add(content.indexOf("负担"));
        indexList.add(content.indexOf("给付"));
        indexList.add(content.indexOf("返还"));
        indexList.add(content.indexOf("偿还"));
        indexList.add(content.indexOf("赔付"));
        indexList.add(content.indexOf("补偿"));
        int result = content.length();
        Iterator var3 = indexList.iterator();

        while(var3.hasNext()) {
            Integer index = (Integer)var3.next();
            if (index.intValue() != -1 && index.intValue() < result) {
                result = index.intValue();
            }
        }

        return result;
    }

    public static void setPjzxqx(PjjgnrModel pjjgnrModel) {
        if (pjjgnrModel != null && !StringUtil.isBlank(pjjgnrModel.getPjjgnr())) {
            String pjjgnr = pjjgnrModel.getPjjgnr();
            int indexOfStart = -1;
            String start = "";
            String[] starts = new String[]{"本判决生效之日起", "于判决生效后", "限判决生效后", "本判决发生法律效力后", "本判决发生法律效力之日起", "限判决生效之日起", "于判决生效之日起", "本判决生效后"};

            int timeStart;
            for(timeStart = 0; timeStart < starts.length; ++timeStart) {
                indexOfStart = pjjgnr.indexOf(starts[timeStart]);
                if (indexOfStart > -1) {
                    start = starts[timeStart];
                    break;
                }
            }

            if (indexOfStart > -1) {
                try {
                    timeStart = indexOfStart + start.length();
                    start = pjjgnr.substring(timeStart, pjjgnr.length());
                    int endIndex = start.indexOf("内");
                    start = start.substring(0, endIndex);
                    pjjgnrModel.setPjzxqx(start);
                } catch (Exception var7) {
                    ;
                }
            }
        }

    }

    public static void setPjzrcdfs(PjjgnrModel pjjgnrModel) {
        if (pjjgnrModel != null && !StringUtil.isBlank(pjjgnrModel.getPjjgnr())) {
            pjjgnrModel.setPjzrcdfs("继续履行");
        }

    }

    public static void setPjje(PjjgnrModel pjjgnrModel, List<String> jelxList) {
        List<PjjeModel> pjjeModels = new ArrayList();
        String content = pjjgnrModel.getPjjgnr();
        String reg = "元";
        String[] nums = content.split(reg);

        for(int i = 0; i < nums.length; ++i) {
            int index = -1;
            char[] chars = nums[i].toCharArray();

            for(int j = chars.length - 1; j > -1; --j) {
                if (!Character.isDigit(nums[i].charAt(j)) && nums[i].charAt(j) != '．' && nums[i].charAt(j) != 19975 && nums[i].charAt(j) != '，') {
                    index = j;
                    break;
                }
            }

            String je_toAdd = StringUtil.ToDBC(nums[i].substring(index + 1, nums[i].length()));
            je_toAdd = je_toAdd.replaceAll(",", "");
            if (!StringUtil.isBlank(je_toAdd)) {
                if (je_toAdd.endsWith("万")) {
                    je_toAdd = je_toAdd.substring(0, je_toAdd.length() - 1);

                    try {
                        Double je_addDou = Double.parseDouble(je_toAdd) * 10000.0D;
                        je_toAdd = je_addDou + "";
                    } catch (Exception var13) {
                        je_toAdd = "";
                    }
                }

                if (!StringUtil.isBlank(je_toAdd)) {
                    PjjeModel jeModel = new PjjeModel();
                    jeModel.setValue(je_toAdd + "元");
                    Iterator var11 = jelxList.iterator();

                    while(var11.hasNext()) {
                        String s = (String)var11.next();
                        if (StringUtil.contains(nums[i], s)) {
                            if (jeModel.getCategorys() == null) {
                                jeModel.setCategorys(new ArrayList());
                            }

                            jeModel.getCategorys().add(s);
                        }
                    }

                    pjjeModels.add(jeModel);
                }
            }
        }

        if (pjjeModels.size() > 0) {
            pjjgnrModel.setPjjeList(pjjeModels);
        }

    }

//    public static void setSsqk(WscpjgModel wscpjgModel, String cpjg) {
//        int indexStart = cpjg.indexOf("上诉于");
//        if (indexStart == -1) {
//            indexStart = cpjg.indexOf("上诉至");
//        }
//
//        int fyIndex = true;
//        String temp = "";
//        int fyIndex;
//        if (indexStart > -1) {
//            temp = cpjg.substring(indexStart);
//            fyIndex = temp.indexOf("法院");
//            if (fyIndex > -1) {
//                wscpjgModel.setKssz(temp.substring(3, fyIndex + 2));
//            }
//        }
//
//        indexStart = cpjg.indexOf("院递交");
//        fyIndex = getMinforSsqk(cpjg);
//        if (indexStart > -1 && fyIndex > -1 && indexStart < fyIndex) {
//            String sscl = cpjg.substring(indexStart + 3, fyIndex).trim();
//            if (sscl.endsWith("，")) {
//                sscl = sscl.substring(0, sscl.length() - 1);
//            }
//
//            wscpjgModel.setSstjcl(sscl);
//        }
//
//        indexStart = cpjg.indexOf("送达之日起");
//        fyIndex = cpjg.indexOf("日内");
//        if (indexStart > -1 && fyIndex > -1 && indexStart < fyIndex) {
//            wscpjgModel.setSsqx(cpjg.substring(indexStart + 5, fyIndex + 1));
//        }
//
//    }

    public static int getMinforSsqk(String content) {
        List<Integer> indexList = new ArrayList();
        indexList.add(content.indexOf("预交"));
        indexList.add(content.indexOf("，交纳"));
        indexList.add(content.indexOf("，并交纳"));
        indexList.add(content.indexOf("交纳"));
        indexList.add(content.indexOf("，同时预交"));
        indexList.add(content.indexOf("上诉于"));
        indexList.add(content.indexOf("上诉至"));
        indexList.add(content.indexOf("按照国务院"));
        indexList.add(content.indexOf("，同时交纳"));
        int result = content.length();
        Iterator var3 = indexList.iterator();

        while(var3.hasNext()) {
            Integer index = (Integer)var3.next();
            if (index.intValue() != -1 && index.intValue() < result) {
                result = index.intValue();
            }
        }

        return result;
    }

    public static void setCsrjh(WscpjgModel wscpjgModel, List<WssscyrModel> wssscyrModellist, String cpjg, BaseWsAnalyseImpl wsAnalyse) {
        List<String> csrjh = new ArrayList();
        Iterator var5 = wssscyrModellist.iterator();

        while(var5.hasNext()) {
            WssscyrModel sscyr = (WssscyrModel)var5.next();
            if (StringUtil.contains(cpjg, sscyr.getSscyr())) {
                csrjh.add(sscyr.getSscyr());
            }
        }

        if (csrjh.size() > 0) {
            wscpjgModel.setCsrjh(csrjh);
            if (StringUtil.contains(wsAnalyse.getSsjl(), "和解")) {
                wscpjgModel.setCslx("原告与被告庭外和解后撤诉");
            } else {
                wscpjgModel.setCslx("原告主动撤诉");
            }
        }

    }

    public static void setSsfcd(WscpjgModel wscpjgModel, List<WssscyrModel> wssscyrModellist) {
        String ssfcdjl = wscpjgModel.getAjslf();
        WsCpjgssfModel ssfModel = new WsCpjgssfModel();
        if (!StringUtil.isBlank(ssfcdjl)) {
            ssfModel.setSsfjl(ssfcdjl);
            int indexOfSsf = -1;
            int indexOfYuan = -1;
            int lengthOfSsfName = -1;
            List<WsCpjgssfjeModel> jeModels = new ArrayList();
            int ssfzje = 0;
            String[] ssfstrList = ssfcdjl.split("元");

            int count;
            String je;
            for(int i = 0; i < ssfstrList.length - 1; ++i) {
                String ssfstr = ssfstrList[i];
                SsfEnum[] var12 = SsfEnum.values();
                count = var12.length;

                for(int var14 = 0; var14 < count; ++var14) {
                    SsfEnum ssfEnum = var12[var14];
                    if (StringUtil.contains(ssfstr, ssfEnum.getSsfName())) {
                        ssfstr = StringUtil.trim(ssfstr);
                        je = ssfstr.substring(ssfEnum.getSsfName().length() + ssfstr.indexOf(ssfEnum.getSsfName()), ssfstr.length());
                        je = je.replace('．', '.');
                        je = je.replaceAll("，", "");
                        if (je.contains("减半收取")) {
                            je = je.substring(je.indexOf("减半收取") + 4);
                        }

                        if (je.contains("（减半收取）")) {
                            je = je.substring(6);
                        }

                        if (StringUtil.contains(je, "共计")) {
                            je = je.substring(2);
                        } else if (StringUtil.contains(je, "计") || StringUtil.contains(je, "各") || StringUtil.contains(je, "为") || StringUtil.contains(je, "即")) {
                            je = je.substring(1);
                        }

                        je = je.replaceAll("人民币", "");
                        if (!StringUtil.isNum(je) && !StringUtil.contains(je, "人民币")) {
                            int jeInt = NumberConverter.convertFromChinese(je);
                            if (jeInt > 10 && je.length() > 1 || jeInt == 10) {
                                je = jeInt + "";
                            }
                        }

                        if (ssfEnum.equals(SsfEnum.JBSQ) && jeModels.size() > 0) {
                            ((WsCpjgssfjeModel)jeModels.get(jeModels.size() - 1)).setValue(je + "元");
                            break;
                        }

                        WsCpjgssfjeModel jeModel = new WsCpjgssfjeModel(je + "元", ssfEnum.getSsfName());
                        jeModels.add(jeModel);

                        try {
                            ssfzje += Integer.parseInt(ssfcdjl.substring(indexOfSsf + lengthOfSsfName, indexOfYuan));
                        } catch (Exception var23) {
                            ;
                        }
                        break;
                    }
                }
            }

            if (jeModels.size() > 0) {
                ssfModel.setSsfjeModels(jeModels);
                ssfModel.setZje(ssfzje + "元");
            }

            List<WscpjgssfcdModel> cdModels = new ArrayList();
            HashMap<String, String> sscyrMap = new HashMap();
            Iterator var26 = wssscyrModellist.iterator();

            while(var26.hasNext()) {
                WssscyrModel sscyr = (WssscyrModel)var26.next();
                sscyrMap.put(sscyr.getSscyr(), sscyr.getSsdw());
            }

            String[] ssfs = ssfcdjl.split("，");
            count = 0;
            String[] var29 = ssfs;
            int var31 = ssfs.length;

            for(int var38 = 0; var38 < var31; ++var38) {
                String s = var29[var38];
                String cdje = getNumberFromString(s);
                List<WscpjgssfcdModel> tempcdModels = new ArrayList();
                if (StringUtil.contains(s, "负担") || StringUtil.contains(s, "承担")) {
                    Iterator var20 = sscyrMap.entrySet().iterator();

                    while(var20.hasNext()) {
                        Map.Entry<String, String> entry = (Map.Entry)var20.next();
                        if (StringUtil.contains(s, (String)entry.getKey())) {
                            ++count;
                            WscpjgssfcdModel cdmodel = new WscpjgssfcdModel();
                            cdmodel.setCdr((String)entry.getKey());
                            cdmodel.setCdrdw((String)entry.getValue());
                            if (!StringUtil.equals(cdje, "0元")) {
                                cdmodel.setCdje(cdje);
                            }

                            cdmodel.setCdfs("与他人共同承担该金额");
                            tempcdModels.add(cdmodel);
                        }
                    }

                    if (tempcdModels.size() == 1) {
                        ((WscpjgssfcdModel)tempcdModels.get(0)).setCdfs("个人独立承担该金额");
                    }

                    cdModels.addAll(tempcdModels);
                }
            }

            boolean jeflag = true;
            Iterator var32 = cdModels.iterator();

            while(var32.hasNext()) {
                WscpjgssfcdModel cdmodel = (WscpjgssfcdModel)var32.next();
                if (!StringUtil.isBlank(cdmodel.getCdje())) {
                    jeflag = false;
                    break;
                }
            }

            if (jeflag) {
                List<WsCpjgssfjeModel> mos = ssfModel.getSsfjeModels();
                if (mos != null && mos.size() > 0 && ((WsCpjgssfjeModel)mos.get(0)).getValue() != null) {
                    je = ((WsCpjgssfjeModel)mos.get(0)).getValue();
                    Iterator var36 = cdModels.iterator();

                    while(var36.hasNext()) {
                        WscpjgssfcdModel cdmodel = (WscpjgssfcdModel)var36.next();
                        cdmodel.setCdje(je);
                    }
                }
            }

            if (cdModels.size() > 0) {
                ssfModel.setSsfcdModels(cdModels);
            }

            wscpjgModel.setSsfModel(ssfModel);
        }

    }

    public static String formatJe(String je) {
        if (StringUtil.isBlank(je)) {
            return null;
        } else {
            StringUtil.replace(je, "，", "");
            StringUtil.replace(je, "．", ".");

            try {
                Double var1 = Double.parseDouble(je);
            } catch (Exception var2) {
                je = NumberConverter.convertFromChinese(je) + "";
            }

            return je;
        }
    }

    public static String getNumberFromString(String content) {
        if (StringUtil.isBlank(content)) {
            return null;
        } else {
            String reg1 = "[^0-9.,](\\d){1,3}(\\,\\d\\d\\d)*(\\d)*(\\.)?(\\d)*元";
            String reg = "(\\d+(\\.\\d+)?)元";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(content);
            return m.find() ? m.group() : null;
        }
    }

    public static List<String> getPjjeLx() {
        String lxs = "[无, 交强险, 损害赔偿金, 价款, 借款, 利息, 罚息, 债权, 律师费, 医疗费, 营养费, 住院伙食补助费, 残疾赔偿金, 交通费, 鉴定费, 护工费, 误工费, 续医费, 精神伤害补助, 工资, 加班工资, 货款, 租金, 卫生费, 本金, 日用品, 违约金, 房款, 损失, 保险赔偿, 车损费, 施救费, 透支款, 贷款, 服务费, 电费, 使用费, 死亡补偿费, 安葬费, 补偿金, 抚养费, 遣返费, 公告费, 担保金, 财产保全费, 承揽费, 报酬, 购物款, 经济补偿金, 资料费, 保险金, 材料款, 工程款, 劳动报酬, 生活费, 经济损失, 折价款, 评估费, 欠款, 检查费, 残疾辅助器费, 食宿费, 聘金, 解除劳动合同赔偿金, 滞纳金, 手续费, 加工价款, 工程造价, 现金, 维修费, 复印费, 债款, 实现债权的费用, 合理费用, 房屋租金, 押金, 加班费, 理赔款, 代理费, 利润, 保险费, 诊疗费, 生活补助费, 住宿费, 被扶养人生活费, 余款, 租赁费, 垫付款, 货物托运费, 培训费, 精神抚慰金, 安装费, 物业费, 抚育费, 投资款, 逾期利息, 伙食补助费, 资金, 遗产, 药费, 安置补助费, 保证金, 修复费, 被抚养人生活费, 本息, 罚款, 装修费, 停车费, 赡养费, 定金, 劳务费, 超限费, 保全申请费, 水费, 修理费, 货物损失, 邮寄费, 料款, 存款, 复利, 其他费用, 煤款, 转让费, 拖车费, 伤残就业补助金, 土地租金, 摩托车费, 住院费, 伤残补助费, 工伤医疗补助金, 律师服务费, 购车款, 转让款, 股权转让款, 伤残鉴定费, 法医鉴定费, 砖款, 查询费, 承包金, 差价款, 交通事故损失, 调查费用, 化肥款, 承揽款, 救护车费, 信用社贷款, 经济帮助, 土地补偿费, 申请费, 承包费, 餐费, 中介费, 设备款, 税费, 施工费, 检测费, 承包款, 物损费, 公证费, 诉讼合理支出, 设计费, 年费, 款项合计, 佣金, 公积金, 补偿费, 预付款, 不当得利款, 钢材款, 抵押金, 抚恤费, 保管费, 供暖费, 吊车费, 伙食费, 财物损失费, 管理费, 酒款, 伤残费, 预约金, 质保费, 土地承包经营费, 高温费, 承揽价款, 石子款, 代通知金, 定损费, 技术服务费, 复诊费, 水泥款, 轮椅费, 教育费, 电话费, 差旅费, 取证费, 衣服损失费, 合同款, 房屋使用费, 查档费, 人工费, 生活帮助费, 照相费, 模具款, 死亡赔偿金, 丧葬费, 精神抚慰金, 经济补偿, 人身损害赔偿金, 出让价款, 停工费]";
        String[] strs = lxs.split(", ");
        List<String> jelx = new ArrayList();
        String[] var3 = strs;
        int var4 = strs.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            if (StringUtil.equals(s, "[无")) {
                s = "无";
            } else if (StringUtil.equals(s, " 停工费]")) {
                s = "停工费";
            }

            jelx.add(s);
        }

        return jelx;
    }

    public static void setTcgxyy(WscpjgModel wscpjgModel, String allNr) {
        if (StringUtil.contains(allNr, "管辖异议")) {
            wscpjgModel.setSftcgxyy("是");
        } else {
            wscpjgModel.setSftcgxyy("否");
        }

    }
}
