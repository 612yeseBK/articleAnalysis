package template.model.BaseModel;

import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * description:
 * Created by gaoyw on 2018/12/17.
 */
public class BaseSSJLModel {

    private String ay; // 案由
    private String aydm;//案由代码
    private String ktsl;//是否开庭审理
    private String ktslxx;//开庭审理信息
    private String larq;//立案日期
    private String spzz;//审判组织  合议庭
    private HashMap<String, String> ctdsrxx;//出庭当事人信息,(诉讼参与人姓名，诉讼身份）


    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public String getKtsl() {
        return ktsl;
    }

    public void setKtsl(String ktsl) {
        this.ktsl = ktsl;
    }

    public String getKtslxx() {
        return ktslxx;
    }

    public void setKtslxx(String ktslxx) {
        this.ktslxx = ktslxx;
    }

    public String getAydm() {
        return aydm;
    }

    public void setAydm(String aydm) {
        this.aydm = aydm;
    }

    public String getLarq() {
        return larq;
    }

    public void setLarq(String larq) {
        this.larq = larq;
    }

    public String getSpzz() {
        return spzz;
    }

    public void setSpzz(String spzz) {
        this.spzz = spzz;
    }

    public HashMap<String, String> getCtdsrxx() {
        return ctdsrxx;
    }

    public void setCtdsrxx(HashMap<String, String> ctdsrxx) {
        this.ctdsrxx = ctdsrxx;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
