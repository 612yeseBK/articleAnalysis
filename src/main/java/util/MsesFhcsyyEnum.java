package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public enum MsesFhcsyyEnum {
    SPZZBHF("������֯����ɲ��Ϸ�"),
    WHB("Ӧ���رܵ�������Աδ�ر�"),
    WNL("��������Ϊ������δ�����������˴�Ϊ����"),
    WFBD("Υ�����ᵱ���˱���Ȩ��"),
    TJBC("��©һ�����������ҵ��ⲻ��"),
    YLDSR("��©����μ����ϵĵ�����"),
    WFQXPJ("Υ��ȱϯ�о�"),
    SSBQ("ԭ�о��϶�������ʵ����"),
    ESYPLH("������ΪӦ���о���飬�Ʋ�����Ů�������ⲻ�ܴ�ɵ���"),
    QT("����");

    String content;

    private MsesFhcsyyEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static String getMsesfhccyy(String content) {
        List<String> allList = new ArrayList();
        MsesJafsEnum[] var2 = MsesJafsEnum.values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            MsesJafsEnum jafs = var2[var4];
            allList.add(jafs.getContent());
        }

        Iterator var6 = allList.iterator();

        String yy;
        do {
            if (!var6.hasNext()) {
                return null;
            }

            yy = (String)var6.next();
        } while(content.indexOf(yy) == -1);

        return yy;
    }
}
