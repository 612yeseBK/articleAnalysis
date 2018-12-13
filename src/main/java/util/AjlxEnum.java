package util;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public enum AjlxEnum {
    MSYS("民事一审", "Msys"),
    MSES("民事二审", "Mses"),
    XZYS("行政一审", "XZYS"),
    XZES("行政二审", "XZES"),
    XSYS("刑事一审", "XSYS"),
    XSES("刑事二审", "XSES");

    private String ajlx;
    private String handlerName;

    private AjlxEnum() {
    }

    private AjlxEnum(String ajlx, String handlerName) {
        this.ajlx = ajlx;
        this.handlerName = handlerName;
    }

    public String getAjlx() {
        return this.ajlx;
    }

    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    public String getHandlerName() {
        return this.handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public static String getHandlerByAjlx(String ajlx) {
        AjlxEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AjlxEnum ajlxEnum = var1[var3];
            if (StringUtil.equals(ajlxEnum.getAjlx(), ajlx)) {
                return ajlxEnum.getHandlerName();
            }
        }

        return null;
    }
}
