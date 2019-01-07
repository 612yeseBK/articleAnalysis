package template.model.BaseModel;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * description:基本模板 -- 诉讼参与人全集部分
 * Created by gaoyw on 2018/12/17.
 */
public class BaseSSCYRQJModel {

    private List<SSCYR> SSCYRQJ = new ArrayList<>();

    public List<SSCYR> getSSCYRQJ() {
        return SSCYRQJ;
    }

    public void setSSCYRQJ(List<SSCYR> SSCYRQJ) {
        this.SSCYRQJ = SSCYRQJ;
    }

    public class SSCYR{
        String sscyrmc;//诉讼参与人名称
        String sssf; //诉讼身份
        String ssdw;//诉讼地位
        String dsrlb;//当事人类别
        String dsrlx;//当事人类型
        String xb;//性别
        String mz;//民族
        String csrq;//出生年月
        String gj;//国籍
        String dsrdz;//当事人地址
        String zw;//职务
        String dtqk;//到停情况

        public String getSscyrmc() {
            return sscyrmc;
        }

        public void setSscyrmc(String sscyrmc) {
            this.sscyrmc = sscyrmc;
        }

        public String getSssf() {
            return sssf;
        }

        public void setSssf(String sssf) {
            this.sssf = sssf;
        }

        public String getSsdw() {
            return ssdw;
        }

        public void setSsdw(String ssdw) {
            this.ssdw = ssdw;
        }

        public String getDsrlb() {
            return dsrlb;
        }

        public void setDsrlb(String dsrlb) {
            this.dsrlb = dsrlb;
        }

        public String getDsrlx() {
            return dsrlx;
        }

        public void setDsrlx(String dsrlx) {
            this.dsrlx = dsrlx;
        }

        public String getXb() {
            return xb;
        }

        public void setXb(String xb) {
            this.xb = xb;
        }

        public String getMz() {
            return mz;
        }

        public void setMz(String mz) {
            this.mz = mz;
        }

        public String getCsrq() {
            return csrq;
        }

        public void setCsrq(String csrq) {
            this.csrq = csrq;
        }

        public String getGj() {
            return gj;
        }

        public void setGj(String gj) {
            this.gj = gj;
        }

        public String getDsrdz() {
            return dsrdz;
        }

        public void setDsrdz(String dsrdz) {
            this.dsrdz = dsrdz;
        }

        public String getZw() {
            return zw;
        }

        public void setZw(String zw) {
            this.zw = zw;
        }

        public String getDtqk() {
            return dtqk;
        }

        public void setDtqk(String dtqk) {
            this.dtqk = dtqk;
        }
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
