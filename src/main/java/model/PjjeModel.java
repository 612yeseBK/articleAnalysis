package model;

import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class PjjeModel {
    private String value;
    private List<String> categorys;
    private String kssj;
    private String jssj;
    private String jsfs;

    public PjjeModel() {
    }

    public PjjeModel(String value, List<String> categorys) {
        this.value = value;
        this.categorys = categorys;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getCategorys() {
        return this.categorys;
    }

    public void setCategorys(List<String> categorys) {
        this.categorys = categorys;
    }

    public String getKssj() {
        return this.kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJssj() {
        return this.jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    public String getJsfs() {
        return this.jsfs;
    }

    public void setJsfs(String jsfs) {
        this.jsfs = jsfs;
    }
}

