package model;

import util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * description:文书
 * Created by gaoyw on 2018/12/10.
 */
public class WsModel implements Serializable {
    private Integer ajxh;
    private Integer wsjbbh;
    private String wslb;
    private String wsmc;
    private String zzh;
    private Date scrq;
    private String scrqStr;
    private String wswjm;
    private String wsnr;
    private String ajlx;
    private String sjlx;
    private String fy;
    private String laay;

    public WsModel() {
    }

    public String getLaay() {
        return this.laay;
    }

    public void setLaay(String laay) {
        this.laay = laay;
    }

    public String getFy() {
        return this.fy;
    }

    public void setFy(String fy) {
        this.fy = fy;
    }

    public String getSjlx() {
        return this.sjlx;
    }

    public void setSjlx(String sjlx) {
        this.sjlx = sjlx;
    }

    public String getAjlx() {
        return this.ajlx;
    }

    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    public void setScrqStr(String scrqStr) {
        this.scrqStr = scrqStr;
    }

    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    public Integer getWsjbbh() {
        return this.wsjbbh;
    }

    public void setWsjbbh(Integer wsjbbh) {
        this.wsjbbh = wsjbbh;
    }

    public String getWslb() {
        return this.wslb;
    }

    public void setWslb(String wslb) {
        this.wslb = wslb;
    }

    public String getWsmc() {
        return this.wsmc;
    }

    public void setWsmc(String wsmc) {
        this.wsmc = wsmc;
    }

    public String getZzh() {
        return this.zzh;
    }

    public void setZzh(String zzh) {
        this.zzh = zzh;
    }

    public Date getScrq() {
        return this.scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
        this.scrqStr = DateUtil.format(scrq, "yyyy-MM-dd");
    }

    public String getScrqStr() {
        return this.scrqStr;
    }

    public String getWswjm() {
        return this.wswjm;
    }

    public void setWswjm(String wswjm) {
        this.wswjm = wswjm;
    }

    public String getWsnr() {
        return this.wsnr;
    }

    public void setWsnr(String wsnr) {
        this.wsnr = wsnr;
    }
}

