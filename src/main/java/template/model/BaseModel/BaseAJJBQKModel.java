package template.model.BaseModel;

import net.sf.json.JSONObject;

/**
 * description:基本模板 -- 案件基本情况部分
 * Created by gaoyw on 2018/12/17.
 */
public class BaseAJJBQKModel {

    private String ygscd; //原告诉称段
    private String bgbcd; //被告辩称段
    private String zjd; //证据段
    private String cmssd; //查明事实段

    public String getYgscd() {
        return ygscd;
    }

    public void setYgscd(String ygscd) {
        this.ygscd = ygscd;
    }

    public String getBgbcd() {
        return bgbcd;
    }

    public void setBgbcd(String bgbcd) {
        this.bgbcd = bgbcd;
    }

    public String getZjd() {
        return zjd;
    }

    public void setZjd(String zjd) {
        this.zjd = zjd;
    }

    public String getCmssd() {
        return cmssd;
    }

    public void setCmssd(String cmssd) {
        this.cmssd = cmssd;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
