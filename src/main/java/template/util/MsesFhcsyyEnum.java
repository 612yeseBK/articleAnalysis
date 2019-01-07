package template.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public enum MsesFhcsyyEnum {
    SPZZBHF("审判组织的组成不合法"),
    WHB("应当回避的审判人员未回避"),
    WNL("无诉讼行为能力人未经法定代理人代为诉讼"),
    WFBD("违法剥夺当事人辩论权利"),
    TJBC("遗漏一审诉讼请求且调解不成"),
    YLDSR("遗漏必须参加诉讼的当事人"),
    WFQXPJ("违法缺席判决"),
    SSBQ("原判决认定基本事实不清"),
    ESYPLH("二审认为应当判决离婚，财产和子女抚养问题不能达成调解"),
    QT("其他");

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
