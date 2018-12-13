package util;

import java.util.ArrayList;
import java.util.List;

/**
 * description:�Ļ��̶�
 * Created by gaoyw on 2018/12/13.
 */
public enum WhcdEnum {
    WM("��ä"),
    XXWH("Сѧ�Ļ�"),
    CZWH("�����Ļ�"),
    ZZWH("��ר�Ļ�"),
    GZWH("�����Ļ�"),
    DZWH("��ר�Ļ�"),
    BKWH("�����Ļ�"),
    DXBKWH("��ѧ�����Ļ�"),
    DXWH("��ѧ�Ļ�");

    private String content;

    private WhcdEnum() {
    }

    private WhcdEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<String> getWhcdList() {
        List<String> whcd = new ArrayList();
        WhcdEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            WhcdEnum whcdEnum = var1[var3];
            whcd.add(whcdEnum.getContent());
        }

        return whcd;
    }

    public static boolean HasWhcd(String whcd) {
        List<String> list = getWhcdList();

        for(int i = 0; i < list.size(); ++i) {
            if (whcd.indexOf((String)list.get(i)) == 0) {
                return true;
            }
        }

        return false;
    }

    public static String getWhcd(String whcd) {
        List<String> list = getWhcdList();

        for(int i = 0; i < list.size(); ++i) {
            if (whcd.indexOf((String)list.get(i)) != -1) {
                return (String)list.get(i);
            }
        }

        return null;
    }
}
