package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public enum MsesJafsEnum {
    WC("维持"),
    JCXDSR("仅撤销第三人撤销之诉判决"),
    GP("改判"),
    ZXCHSS("准予撤回上诉"),
    TJ("调解"),
    CXYCPBHQS("撤销原判并驳回起诉"),
    FHCS("发挥重审"),
    YSQTFY("撤销原判并裁定移送其他法院管辖"),
    ACHSSCL("按撤回上诉处理"),
    ZYCHQSCXYSPJ("准予撤回起诉并撤销一审判决"),
    ZLSL("撤销原裁定并指令审理"),
    CXZLSL("撤销原裁定并指令受理");

    private String content;

    private MsesJafsEnum() {
    }

    private MsesJafsEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<String> getAll() {
        List<String> jafsList = new ArrayList();
        MsesJafsEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            MsesJafsEnum jafs = var1[var3];
            jafsList.add(jafs.getContent());
        }

        return jafsList;
    }

    public static String getMsesjafs(String pjjg) {
        List<String> jafsList = getAll();
        Iterator var2 = jafsList.iterator();

        String jafs;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            jafs = (String)var2.next();
        } while(pjjg.indexOf(jafs) == -1);

        return jafs;
    }
}
