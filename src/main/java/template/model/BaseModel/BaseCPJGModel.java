package template.model.BaseModel;

/**
 * description:基本模板 -- 裁判结果部分
 * Created by gaoyw on 2018/12/17.
 */
public class BaseCPJGModel {
    private String jafs;  //结案方式
    private String jtcpd; //具体裁判段
    private String ssfcd; //诉讼费承担
    private String kffhcs; // 可否发回重审
    private String kssz; //可上诉至
    private String sstjcl; //上诉提交材料
    private String ssqx; //上诉期限
    private String sftcgxyy; //是否提出管辖异议
//    private String sfzcssqq;
//    private String sbsf;
//    private String sfzcxzpc;
//    private String xzpcje;
//    private List<String> jabde;
//    private String jabdze;
//    private String sffhcs;
//    private String fhcsyy;
//    private List<PjjgnrModel> pjjgList;
//
//    private List<String> csrjh;
//    private String cslx;
//    private WsCpjgssfModel ssfModel;
//
//    private String pcsxsfzq;
//    private String bsgssfbg;


    public String getJafs() {
        return jafs;
    }

    public void setJafs(String jafs) {
        this.jafs = jafs;
    }

    public String getJtcpd() {
        return jtcpd;
    }

    public void setJtcpd(String jtcpd) {
        this.jtcpd = jtcpd;
    }

    public String getSsfcd() {
        return ssfcd;
    }

    public void setSsfcd(String ssfcd) {
        this.ssfcd = ssfcd;
    }

    public String getKffhcs() {
        return kffhcs;
    }

    public void setKffhcs(String kffhcs) {
        this.kffhcs = kffhcs;
    }

    public String getKssz() {
        return kssz;
    }

    public void setKssz(String kssz) {
        this.kssz = kssz;
    }

    public String getSstjcl() {
        return sstjcl;
    }

    public void setSstjcl(String sstjcl) {
        this.sstjcl = sstjcl;
    }

    public String getSsqx() {
        return ssqx;
    }

    public void setSsqx(String ssqx) {
        this.ssqx = ssqx;
    }

    public String getSftcgxyy() {
        return sftcgxyy;
    }

    public void setSftcgxyy(String sftcgxyy) {
        this.sftcgxyy = sftcgxyy;
    }
}
