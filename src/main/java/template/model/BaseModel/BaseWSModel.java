package template.model.BaseModel;

/**
 * description:基本模板 -- 文首部分
 * Created by gaoyw on 2018/12/17.
 */
public class BaseWSModel {
    private String jbfy;  //经办法院
    private String wsmc;  //文书名称
    private String ah;  //案号
    private String land;  //立案年度
    private String wszzdw;  //文书制作单位
    private String fyjb;  //法院级别
    private String xzqhProv;  //行政区划（省）
    private String xzqhCity;  //行政区划（城市）
    private String wszl;  //文书种类
    private String ajxz;  //案件性质
    private String spcx;  //审判程序
    private String ajlx;  //案件类型

    public String getJbfy() {
        return jbfy;
    }

    public void setJbfy(String jbfy) {
        this.jbfy = jbfy;
    }

    public String getWsmc() {
        return wsmc;
    }

    public void setWsmc(String wsmc) {
        this.wsmc = wsmc;
    }

    public String getAh() {
        return ah;
    }

    public void setAh(String ah) {
        this.ah = ah;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getWszzdw() {
        return wszzdw;
    }

    public void setWszzdw(String wszzdw) {
        this.wszzdw = wszzdw;
    }

    public String getFyjb() {
        return fyjb;
    }

    public void setFyjb(String fyjb) {
        this.fyjb = fyjb;
    }

    public String getWszl() {
        return wszl;
    }

    public void setWszl(String wszl) {
        this.wszl = wszl;
    }

    public String getAjxz() {
        return ajxz;
    }

    public void setAjxz(String ajxz) {
        this.ajxz = ajxz;
    }

    public String getSpcx() {
        return spcx;
    }

    public void setSpcx(String spcx) {
        this.spcx = spcx;
    }

    public String getAjlx() {
        return ajlx;
    }

    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    public String getXzqhProv() {
        return xzqhProv;
    }

    public void setXzqhProv(String xzqhProv) {
        this.xzqhProv = xzqhProv;
    }

    public String getXzqhCity() {
        return xzqhCity;
    }

    public void setXzqhCity(String xzqhCity) {
        this.xzqhCity = xzqhCity;
    }

    public String toString(){
        return "jbfy:"+jbfy+";wsmc:"+wsmc+";ah:"+ah+";land:"+land+";wszzdw:"+wszzdw+";fyjb:"+fyjb+";xzqhProv:"+xzqhProv
                +";xzqhCity:"+xzqhCity+";wszl:"+wszl+";ajxz:"+ajxz+";spcx:"+spcx+";ajlx:"+ajlx;
    }
}

