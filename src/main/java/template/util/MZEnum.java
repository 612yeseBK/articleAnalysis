package template.util;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public enum MZEnum {
    HZ("汉族"),
    MZ("满族"),
    HUIZ("回族"),
    MGZ("蒙古族"),
    ZZ("藏族"),
    WWEZ("维吾尔族"),
    MIAOZ("苗族"),
    YZ("彝族"),
    BYZ("布依族"),
    ZHZ("壮族"),
    CXZ("朝鲜族"),
    DZ("侗族"),
    YAOZ("瑶族"),
    BZ("白族"),
    TJZ("土家族"),
    HSKZ("哈萨克族"),
    DAIZ("傣族"),
    SSZ("僳僳族"),
    WZ("佤族"),
    SZ("畲族"),
    GSZ("高山族"),
    QZ("羌族"),
    TZ("土族"),
    SHUIZ("水族"),
    ELSZ("俄罗斯族"),
    BAZ("保安族"),
    TJKZ("塔吉克族"),
    NZ("怒族"),
    HNZ("哈尼族");

    private String content;

    private MZEnum() {
    }

    private MZEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<String> getMZList() {
        List<String> mzList = new ArrayList();
        MZEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            MZEnum mzEnum = var1[var3];
            mzList.add(mzEnum.getContent());
        }

        return mzList;
    }

    public static boolean HasMZ(String mz) {
        List<String> list = getMZList();

        for(int i = 0; i < list.size(); ++i) {
            if (mz.indexOf((String)list.get(i)) == 0) {
                return true;
            }
        }

        return false;
    }

    public static String getMZ(String mz) {
        List<String> list = getMZList();

        for(int i = 0; i < list.size(); ++i) {
            if (mz.indexOf((String)list.get(i)) != -1) {
                return (String)list.get(i);
            }
        }

        return null;
    }
}
