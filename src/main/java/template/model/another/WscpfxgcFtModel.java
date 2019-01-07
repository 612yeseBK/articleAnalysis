package template.model.another;

import java.util.HashMap;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class WscpfxgcFtModel {
    private String flftmc;
    private HashMap<String, String> ftMap;

    public WscpfxgcFtModel() {
    }

    public String getFlftmc() {
        return this.flftmc;
    }

    public void setFlftmc(String flftmc) {
        this.flftmc = flftmc;
    }

    public HashMap<String, String> getFtMap() {
        return this.ftMap;
    }

    public void setFtMap(HashMap<String, String> ftMap) {
        this.ftMap = ftMap;
    }
}

