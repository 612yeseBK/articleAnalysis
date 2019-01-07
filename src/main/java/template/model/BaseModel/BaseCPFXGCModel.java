package template.model.BaseModel;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * description:基本模板 -- 裁判分析过程
 * Created by gaoyw on 2018/12/17.
 */
public class BaseCPFXGCModel {

    private String jafslx; //结案方式类型
    private List<FT> flft = new ArrayList<>(); //(法律名称，条目) 组成的 法律法条 依据

    public String getJafslx() {
        return jafslx;
    }

    public void setJafslx(String jafslx) {
        this.jafslx = jafslx;
    }

    public List<FT> getFlft() {
        return flft;
    }

    public void setFlft(List<FT> flft) {
        this.flft = flft;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }

    public class FT{
        private String ftmc;  //法条名称
        private HashMap<String,String> tmkm;//（条目，款目）

        public String getFtmc() {
            return ftmc;
        }

        public void setFtmc(String ftmc) {
            this.ftmc = ftmc;
        }

        public HashMap<String, String> getTmkm() {
            return tmkm;
        }

        public void setTmkm(HashMap<String, String> tmkm) {
            this.tmkm = tmkm;
        }
    }
}
