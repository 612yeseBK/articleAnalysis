package model;

/**
 * description:文书分段
 * Created by gaoyw on 2018/12/10.
 */
public class WsfdModel {
    private String qw;  //全文
    private String ws;  //文首
    private String sscyr;  //诉讼参与人
    private String ssjl;  //诉讼记录
    private String ajjbqk;  //案件基本情况
    private String cpfxgc;  //裁判分析过程
    private String cpjg;  //裁判结果
    private String ww;  //文尾
    private String fl;  //附录

    public WsfdModel() {
    }

    public String getSscyr() {
        return this.sscyr;
    }

    public void setSscyr(String sscyr) {
        this.sscyr = sscyr;
    }

    public String getQw() {
        return this.qw;
    }

    public void setQw(String qw) {
        this.qw = qw;
    }

    public String getWs() {
        return this.ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public String getAjjbqk() {
        return this.ajjbqk;
    }

    public void setAjjbqk(String ajjbqk) {
        this.ajjbqk = ajjbqk;
    }

    public String getCpfxgc() {
        return this.cpfxgc;
    }

    public void setCpfxgc(String cpfxgc) {
        this.cpfxgc = cpfxgc;
    }

    public String getCpjg() {
        return this.cpjg;
    }

    public void setCpjg(String cpjg) {
        this.cpjg = cpjg;
    }

    public String getWw() {
        return this.ww;
    }

    public void setWw(String ww) {
        this.ww = ww;
    }

    public String getFl() {
        return this.fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getSsjl() {
        return this.ssjl;
    }

    public void setSsjl(String ssjl) {
        this.ssjl = ssjl;
    }
}

