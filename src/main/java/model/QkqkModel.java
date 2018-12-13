package model;

import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class QkqkModel {
    private String qklb;
    private String cfTime;
    private List<String> cfReason;
    private String cfdw;
    private String cfxs;
    private List<String> cfxq;
    private String xmsfTime;

    public QkqkModel() {
    }

    public String getQklb() {
        return this.qklb;
    }

    public void setQklb(String qklb) {
        this.qklb = qklb;
    }

    public String getCfTime() {
        return this.cfTime;
    }

    public void setCfTime(String cfTime) {
        this.cfTime = cfTime;
    }

    public List<String> getCfReason() {
        return this.cfReason;
    }

    public void setCfReason(List<String> cfReason) {
        this.cfReason = cfReason;
    }

    public String getCfdw() {
        return this.cfdw;
    }

    public void setCfdw(String cfdw) {
        this.cfdw = cfdw;
    }

    public String getCfxs() {
        return this.cfxs;
    }

    public void setCfxs(String cfxs) {
        this.cfxs = cfxs;
    }

    public List<String> getCfxq() {
        return this.cfxq;
    }

    public void setCfxq(List<String> cfxq) {
        this.cfxq = cfxq;
    }

    public String getXmsfTime() {
        return this.xmsfTime;
    }

    public void setXmsfTime(String xmsfTime) {
        this.xmsfTime = xmsfTime;
    }
}
