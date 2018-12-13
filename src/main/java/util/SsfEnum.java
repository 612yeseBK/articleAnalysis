package util;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public enum SsfEnum {
    SLF("�����"),
    SSFY("���Ϸ���"),
    SSF("���Ϸ�"),
    CCBQF("�Ʋ���ȫ�����"),
    BQF("��ȫ��"),
    GGF("�����"),
    JDF("������"),
    YDF("�ʵݷ�"),
    YDSDF("�ʼ��ʹ��"),
    QTFY("��������"),
    QTF("����"),
    JBSQ("������ȡ"),
    JBJN("���뽻��");

    private String ssfName;

    private SsfEnum() {
    }

    private SsfEnum(String ssfName) {
        this.ssfName = ssfName;
    }

    public String getSsfName() {
        return this.ssfName;
    }

    public void setSsfName(String ssfName) {
        this.ssfName = ssfName;
    }
}
