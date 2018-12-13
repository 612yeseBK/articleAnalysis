package util;

import java.util.ArrayList;
import java.util.List;

/**
 * description:ְ��
 * Created by gaoyw on 2018/12/13.
 */
public enum ZWEnum {
    LS("��ʦ"),
    FWZY("����רԱ"),
    TXGR("���ݹ���"),
    GR("����"),
    NM("ũ��"),
    GCS("����ʦ"),
    MS("����"),
    FLGW("���ɹ���"),
    GW("����"),
    JS("��ʦ"),
    SJS("���ʦ"),
    SJ("˾��"),
    JSY("��ʻԱ"),
    JIS("��ʦ"),
    MDS("���ʦ"),
    CS("��ʦ"),
    CSZ("��ʦ��"),
    MJ("��"),
    FZZ("��վ��"),
    KJ("���"),
    CN("����"),
    ZZ("վ��"),
    DZ("�곤"),
    GS("���� "),
    FZR("������"),
    BGSZW("�칫������"),
    ZR("����"),
    FZJ("���ܼ�"),
    CWZJ("�����ܼ�"),
    ZJ("�ܼ�"),
    ZL("����"),
    ZC("�ܲ�"),
    ZXDS("ִ�ж���"),
    DSZ("���³�"),
    DS("����"),
    ZY("ְԱ"),
    YG("Ա��"),
    FBZ("������"),
    BZ("����"),
    FZJL("���ܾ���"),
    ZJL("�ܾ���"),
    FJL("������"),
    JL("����"),
    DWWW("��ίίԱ"),
    DWSJ("��ί���"),
    DWFSJ("��ί�����"),
    FCZ("������"),
    CZ("����"),
    FHZ("���г�"),
    HZ("�г�"),
    FZG("������"),
    ZG("����"),
    FDDBR("����������"),
    YTX("������"),
    ZYZY("����ְҵ"),
    WZY("��ְҵ"),
    WGDZY("�޹̶�ְҵ"),
    GZRY("������Ա"),
    WY("��ҵ"),
    NTZG("����ְ��"),
    TXZG("����ְ��"),
    ZHG("ְ��"),
    GTJYZ("���徭Ӫ��"),
    TXGB("���ݸɲ�"),
    JZ("�ֳ�"),
    GB("�ɲ�"),
    ZHZ("��"),
    WN("��ũ"),
    WG("��"),
    GT("����");

    private String content;

    private ZWEnum() {
    }

    private ZWEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<String> getZWList() {
        List<String> zwlist = new ArrayList();
        ZWEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ZWEnum zwEnum = var1[var3];
            zwlist.add(zwEnum.getContent());
        }

        return zwlist;
    }

    public static boolean HasZW(String zw) {
        List<String> list = getZWList();

        for(int i = 0; i < list.size(); ++i) {
            if (zw.indexOf((String)list.get(i)) == 0) {
                return true;
            }
        }

        return false;
    }

    public static String getZW(String zw) {
        List<String> list = getZWList();

        for(int i = 0; i < list.size(); ++i) {
            if (zw.indexOf((String)list.get(i)) != -1) {
                return (String)list.get(i);
            }
        }

        return null;
    }
}

