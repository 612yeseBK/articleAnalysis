package util;

import java.util.ArrayList;
import java.util.List;

public enum HeadEnum {
    FDDLR("法定代理人"),
    WTDLR("委托代理人"),
    WTRDLR("委托人代理人"),
    TBSQDLR("特别授权代理人"),
    SSDLR("诉讼代理人"),
    YSZSR("原审自诉人"),
    DZ("地址"),
    TZR("投资人"),
    JYZ("经营者"),
    ZRR("责任人"),
    BSSR("被上诉人"),
    SSR("上诉人"),
    BGDW("被告单位"),
    FZR("负责人"),
    ZDBHR("指定辩护人"),
    WTBHR("委托辩护人"),
    BHR("辩护人"),
    BIHR("辨护人"),
    BH("辩护"),
    ZSSQR("再审申请人"),
    FDDBR("法定代表人"),
    FDDB("法定代表"),
    YSFDMSSSBGR("原审附带民事诉讼被告人"),
    YSFDMSSSYGR("原审附带民事诉讼原告人"),
    SSDW("上诉单位"),
    ZSRJFDMSSSYGR("自诉人暨附带民事诉讼原告人"),
    ZSRJMSSSYGR("自诉人暨民事诉讼原告人"),
    FDMSSSYGR("附带民事诉讼原告人"),
    FDMSSSBGR("附带民事诉讼被告人"),
    FDMSSSBG("附带民事诉讼被告"),
    SHSR("申诉人"),
    ZF("罪犯"),
    DBR("代表人"),
    BSQR("被申请人"),
    BSHSR("被申诉人"),
    YSBGR("原审被告人"),
    YSYG("原审原告"),
    YSSBG("原审被告"),
    YSFDMSSS("原审附带民事诉讼"),
    SSDB("诉讼代表"),
    YSGSJG("原审公诉机关"),
    YGSJG("原公诉机关"),
    GSJG("公诉机关"),
    KSJG("抗诉机关"),
    WTDW("委托单位"),
    CTXZSZ("出庭行政首长"),
    SSDBR("诉讼代表人"),
    SQDB("授权代表"),
    WTDL("委托代理"),
    YSBG("一审被告"),
    YSDSR("一审当事人"),
    ESDSR("二审当事人"),
    ZSR("自诉人"),
    YZ("业主"),
    YSBHR("原审被害人"),
    BHAIR("被害人"),
    SQR("申请人"),
    ZQ("债权"),
    ZW("债务"),
    DSR("第三人"),
    SQZXR("申请执行人"),
    GLR("管理人"),
    YGR("原告人"),
    BGR("被告人"),
    AWR("案外人"),
    QSR("起诉人"),
    FDJHR("法定监护人"),
    BZXR("被执行人"),
    SQBZXR("申请被执行人"),
    SQZSR("申请再审人"),
    PCQQR("赔偿请求人"),
    FYR("翻译人"),
    QQR("请求人"),
    SQBQR("申请保全人"),
    SYFY("手语翻译"),
    YYFY("哑语翻译"),
    JGDM("机构代码"),
    ZXSWHHR("执行事务合伙人"),
    YG("原告"),
    BG("被告"),
    YSDSREN("原审第三人"),
    ZXR("执行人"),
    ZZJGDM("组织机构代码");

    private String content;

    HeadEnum() {
    }

    private HeadEnum(String content) {
        this.content = content;
    }

    public static List<String> getHeadList() {
        List<String> headList = new ArrayList<String>();
        for (HeadEnum headEnum : HeadEnum.values()) {
            headList.add(headEnum.getContent());
        }
        return headList;
    }

    public static boolean HasHead(String head) {
        List<String> list = getHeadList();
        for (int i = 0; i < list.size(); i++) {
            if (head.indexOf("代理人") > -1) {
                return true;
            }
            if (head.indexOf(list.get(i)) > -1 && head.indexOf(list.get(i)) < 10) {
/*				System.out.println(head);*/
                return true;
            }
        }
        return false;
    }

    public static String getHead(String head) {
        List<String> list = getHeadList();
        for (int i = 0; i < list.size(); i++) {

            if (head.indexOf(list.get(i)) > -1) {
/*				System.out.println(head);*/
                return list.get(i);
            }
        }
        return null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
