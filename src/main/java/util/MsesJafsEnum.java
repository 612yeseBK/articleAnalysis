package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public enum MsesJafsEnum {
    WC("ά��"),
    JCXDSR("�����������˳���֮���о�"),
    GP("����"),
    ZXCHSS("׼�賷������"),
    TJ("����"),
    CXYCPBHQS("����ԭ�в���������"),
    FHCS("��������"),
    YSQTFY("����ԭ�в��ö�����������Ժ��Ͻ"),
    ACHSSCL("���������ߴ���"),
    ZYCHQSCXYSPJ("׼�賷�����߲�����һ���о�"),
    ZLSL("����ԭ�ö���ָ������"),
    CXZLSL("����ԭ�ö���ָ������");

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
