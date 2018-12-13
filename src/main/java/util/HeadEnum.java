package util;

import java.util.ArrayList;
import java.util.List;

public enum HeadEnum {
    FDDLR("����������"),
    WTDLR("ί�д�����"),
    WTRDLR("ί���˴�����"),
    TBSQDLR("�ر���Ȩ������"),
    SSDLR("���ϴ�����"),
    YSZSR("ԭ��������"),
    DZ("��ַ"),
    TZR("Ͷ����"),
    JYZ("��Ӫ��"),
    ZRR("������"),
    BSSR("��������"),
    SSR("������"),
    BGDW("���浥λ"),
    FZR("������"),
    ZDBHR("ָ���绤��"),
    WTBHR("ί�б绤��"),
    BHR("�绤��"),
    BIHR("�滤��"),
    BH("�绤"),
    ZSSQR("����������"),
    FDDBR("����������"),
    FDDB("��������"),
    YSFDMSSSBGR("ԭ�󸽴��������ϱ�����"),
    YSFDMSSSYGR("ԭ�󸽴���������ԭ����"),
    SSDW("���ߵ�λ"),
    ZSRJFDMSSSYGR("�������߸�����������ԭ����"),
    ZSRJMSSSYGR("����������������ԭ����"),
    FDMSSSYGR("������������ԭ����"),
    FDMSSSBGR("�����������ϱ�����"),
    FDMSSSBG("�����������ϱ���"),
    SHSR("������"),
    ZF("�ﷸ"),
    DBR("������"),
    BSQR("��������"),
    BSHSR("��������"),
    YSBGR("ԭ�󱻸���"),
    YSYG("ԭ��ԭ��"),
    YSSBG("ԭ�󱻸�"),
    YSFDMSSS("ԭ�󸽴���������"),
    SSDB("���ϴ���"),
    YSGSJG("ԭ���߻���"),
    YGSJG("ԭ���߻���"),
    GSJG("���߻���"),
    KSJG("���߻���"),
    WTDW("ί�е�λ"),
    CTXZSZ("��ͥ�����׳�"),
    SSDBR("���ϴ�����"),
    SQDB("��Ȩ����"),
    WTDL("ί�д���"),
    YSBG("һ�󱻸�"),
    YSDSR("һ������"),
    ESDSR("��������"),
    ZSR("������"),
    YZ("ҵ��"),
    YSBHR("ԭ�󱻺���"),
    BHAIR("������"),
    SQR("������"),
    ZQ("ծȨ"),
    ZW("ծ��"),
    DSR("������"),
    SQZXR("����ִ����"),
    GLR("������"),
    YGR("ԭ����"),
    BGR("������"),
    AWR("������"),
    QSR("������"),
    FDJHR("�����໤��"),
    BZXR("��ִ����"),
    SQBZXR("���뱻ִ����"),
    SQZSR("����������"),
    PCQQR("�⳥������"),
    FYR("������"),
    QQR("������"),
    SQBQR("���뱣ȫ��"),
    SYFY("���﷭��"),
    YYFY("���﷭��"),
    JGDM("��������"),
    ZXSWHHR("ִ������ϻ���"),
    YG("ԭ��"),
    BG("����"),
    YSDSREN("ԭ�������"),
    ZXR("ִ����"),
    ZZJGDM("��֯��������");

    private String content;

    HeadEnum() {
    }

    private HeadEnum(String content) {
        this.content = content;
    }

    public static List<String> getHeadList() {
        List<String> headList = new ArrayList<String>();
        for (HeadEnum headEnum : HeadEnum.values()) {
            headList.add(headEnum.getContent());
        }
        return headList;
    }

    public static boolean HasHead(String head) {
        List<String> list = getHeadList();
        for (int i = 0; i < list.size(); i++) {
            if (head.indexOf("������") > -1) {
                return true;
            }
            if (head.indexOf(list.get(i)) > -1 && head.indexOf(list.get(i)) < 10) {
/*				System.out.println(head);*/
                return true;
            }
        }
        return false;
    }

    public static String getHead(String head) {
        List<String> list = getHeadList();
        for (int i = 0; i < list.size(); i++) {

            if (head.indexOf(list.get(i)) > -1) {
/*				System.out.println(head);*/
                return list.get(i);
            }
        }
        return null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
