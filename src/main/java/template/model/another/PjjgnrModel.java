package template.model.another;

import java.util.List;
import java.util.Map;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class PjjgnrModel {
    String pjjgnr;
    Map<String, String> qlr;
    Map<String, String> ywr;
    private String pjzxqx;
    private String pjzrcdfs;
    private List<PjjeModel> pjjeList;

    public PjjgnrModel() {
    }

    public PjjgnrModel(String pjjgnr, Map<String, String> qlr, Map<String, String> ywr) {
        this.pjjgnr = pjjgnr;
        this.qlr = qlr;
        this.ywr = ywr;
    }

    public PjjgnrModel(String pjjgnr) {
        this.pjjgnr = pjjgnr;
    }

    public String getPjjgnr() {
        return this.pjjgnr;
    }

    public void setPjjgnr(String pjjgnr) {
        this.pjjgnr = pjjgnr;
    }

    public Map<String, String> getQlr() {
        return this.qlr;
    }

    public void setQlr(Map<String, String> qlr) {
        this.qlr = qlr;
    }

    public Map<String, String> getYwr() {
        return this.ywr;
    }

    public void setYwr(Map<String, String> ywr) {
        this.ywr = ywr;
    }

    public String getPjzxqx() {
        return this.pjzxqx;
    }

    public void setPjzxqx(String pjzxqx) {
        this.pjzxqx = pjzxqx;
    }

    public String getPjzrcdfs() {
        return this.pjzrcdfs;
    }

    public void setPjzrcdfs(String pjzrcdfs) {
        this.pjzrcdfs = pjzrcdfs;
    }

    public List<PjjeModel> getPjjeList() {
        return this.pjjeList;
    }

    public void setPjjeList(List<PjjeModel> pjjeList) {
        this.pjjeList = pjjeList;
    }
}

