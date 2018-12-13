package model;

import java.util.List;

/**
 * description:裁判结果诉讼费
 * Created by gaoyw on 2018/12/10.
 */
public class WsCpjgssfModel {
    private String ssfjl;
    private List<WsCpjgssfjeModel> ssfjeModels; //诉讼费金额
    private List<WscpjgssfcdModel> ssfcdModels;  //诉讼费承担
    private String jnqk;  //
    private String zje; //总金额

    public WsCpjgssfModel() {
    }

    public String getSsfjl() {
        return this.ssfjl;
    }

    public void setSsfjl(String ssfjl) {
        this.ssfjl = ssfjl;
    }

    public List<WsCpjgssfjeModel> getSsfjeModels() {
        return this.ssfjeModels;
    }

    public void setSsfjeModels(List<WsCpjgssfjeModel> ssfjeModels) {
        this.ssfjeModels = ssfjeModels;
    }

    public List<WscpjgssfcdModel> getSsfcdModels() {
        return this.ssfcdModels;
    }

    public void setSsfcdModels(List<WscpjgssfcdModel> ssfcdModels) {
        this.ssfcdModels = ssfcdModels;
    }

    public String getJnqk() {
        return this.jnqk;
    }

    public void setJnqk(String jnqk) {
        this.jnqk = jnqk;
    }

    public String getZje() {
        return this.zje;
    }

    public void setZje(String zje) {
        this.zje = zje;
    }
}
