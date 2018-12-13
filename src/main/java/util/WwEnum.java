package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:��β��һЩ��Ϣ
 * Created by gaoyw on 2018/12/13.
 */
public enum WwEnum {
    SPZ("���г�"),
    RMPSY("��������Ա"),
    DLSPY("��������Ա"),
    RMSPY("��������Ա"),
    SPY("����Ա"),
    DLSJY("�������Ա"),
    DSJY("�����Ա"),
    DKSJY("���������Ա"),
    SJYD("���Ա������"),
    JXSJY("��ϰ���Ա"),
    SJYJ("���Ա���棩"),
    SJY("���Ա"),
    SLY("��¼Ա"),
    FGZL("��������");

    private String content;

    private WwEnum() {
    }

    private WwEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<String> getWwList() {
        List<String> wwList = new ArrayList();
        WwEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            WwEnum wwEnum = var1[var3];
            wwList.add(wwEnum.getContent());
        }

        return wwList;
    }

    public static boolean HasWw(String ww) {
        List<String> list = getWwList();

        for(int i = 0; i < list.size(); ++i) {
            if (ww.indexOf((String)list.get(i)) == 0) {
                return true;
            }
        }

        return false;
    }

    public static String getWw(String ww) {
        List<String> list = getWwList();

        for(int i = 0; i < list.size(); ++i) {
            if (ww.indexOf((String)list.get(i)) != -1) {
                return (String)list.get(i);
            }
        }

        return null;
    }

    public static List<String> getSsdwlist(String ww) {
        List<String> list = getWwList();
        String temp = ww;
        List<String> result = new ArrayList();
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            String s = (String)var4.next();
            if (StringUtil.indexOf(temp, s) > -1) {
                result.add(s);
                temp = temp.substring(s.length());
            }
        }

        return result;
    }

    public static String getSsdwreg(String ww) {
        List<String> list = getWwList();
        String temp = ww;
        String result = "";
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            String s = (String)var4.next();
            if (StringUtil.indexOf(temp, s) > -1) {
                result = result + s + "|";
                temp = temp.substring(s.length());
            }
        }

        if (!StringUtil.isBlank(result)) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    public static void main(String[] arg) {
        String text = "��������Ա";
    }

    public static String addBlank(String content) {
        WwEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            WwEnum ww = var1[var3];
            if (StringUtil.contains(content, ww.getContent())) {
                content = content.replace(ww.getContent(), " " + ww.getContent());
            }
        }

        return content;
    }
}
