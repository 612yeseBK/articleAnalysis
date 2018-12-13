package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:文尾的一些信息
 * Created by gaoyw on 2018/12/13.
 */
public enum WwEnum {
    SPZ("审判长"),
    RMPSY("人民陪审员"),
    DLSPY("代理审判员"),
    RMSPY("人民审判员"),
    SPY("审判员"),
    DLSJY("代理书记员"),
    DSJY("代书记员"),
    DKSJY("（代）书记员"),
    SJYD("书记员（代）"),
    JXSJY("见习书记员"),
    SJYJ("书记员（兼）"),
    SJY("书记员"),
    SLY("速录员"),
    FGZL("法官助理");

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
        String text = "代理审判员";
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
