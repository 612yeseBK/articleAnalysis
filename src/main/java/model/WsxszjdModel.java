package model;

import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class WsxszjdModel {
    private String rdss;
    private List<String> zjjl;

    public WsxszjdModel() {
    }

    public String getRdss() {
        return this.rdss;
    }

    public void setRdss(String rdss) {
        this.rdss = rdss;
    }

    public List<String> getZjjl() {
        return this.zjjl;
    }

    public void setZjjl(List<String> zjjl) {
        this.zjjl = zjjl;
    }
}

