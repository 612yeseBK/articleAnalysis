package model;

/**
 * description:裁判结果诉讼费承担
 * Created by gaoyw on 2018/12/10.
 */
public class WscpjgssfcdModel {
    private String cdr;
    private String cdrdw;
    private String cdje;
    private String cdfs;

    public WscpjgssfcdModel() {
    }

    public WscpjgssfcdModel(String cdr, String cdrdw, String cdje, String cdfs) {
        this.cdr = cdr;
        this.cdrdw = cdrdw;
        this.cdje = cdje;
        this.cdfs = cdfs;
    }

    public String getCdr() {
        return this.cdr;
    }

    public void setCdr(String cdr) {
        this.cdr = cdr;
    }

    public String getCdrdw() {
        return this.cdrdw;
    }

    public void setCdrdw(String cdrdw) {
        this.cdrdw = cdrdw;
    }

    public String getCdje() {
        return this.cdje;
    }

    public void setCdje(String cdje) {
        this.cdje = cdje;
    }

    public String getCdfs() {
        return this.cdfs;
    }

    public void setCdfs(String cdfs) {
        this.cdfs = cdfs;
    }
}

