package util;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public enum MZEnum {
    HZ("����"),
    MZ("����"),
    HUIZ("����"),
    MGZ("�ɹ���"),
    ZZ("����"),
    WWEZ("ά�����"),
    MIAOZ("����"),
    YZ("����"),
    BYZ("������"),
    ZHZ("׳��"),
    CXZ("������"),
    DZ("����"),
    YAOZ("����"),
    BZ("����"),
    TJZ("������"),
    HSKZ("��������"),
    DAIZ("����"),
    SSZ("������"),
    WZ("����"),
    SZ("���"),
    GSZ("��ɽ��"),
    QZ("Ǽ��"),
    TZ("����"),
    SHUIZ("ˮ��"),
    ELSZ("����˹��"),
    BAZ("������"),
    TJKZ("��������"),
    NZ("ŭ��"),
    HNZ("������");

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
