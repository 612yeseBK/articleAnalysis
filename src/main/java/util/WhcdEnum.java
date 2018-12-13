package util;

import java.util.ArrayList;
import java.util.List;

/**
 * description:文化程度
 * Created by gaoyw on 2018/12/13.
 */
public enum WhcdEnum {
    WM("文盲"),
    XXWH("小学文化"),
    CZWH("初中文化"),
    ZZWH("中专文化"),
    GZWH("高中文化"),
    DZWH("大专文化"),
    BKWH("本科文化"),
    DXBKWH("大学本科文化"),
    DXWH("大学文化");

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
