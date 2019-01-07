package template.model.another;

import java.util.ArrayList;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class WsssjlZkjlModel {
    private ArrayList<String> xgr;
    private ArrayList<WsssjlZkzmModel> zkzmModelist;

    public WsssjlZkjlModel() {
    }

    public ArrayList<String> getXgr() {
        return this.xgr;
    }

    public void setXgr(ArrayList<String> xgr) {
        this.xgr = xgr;
    }

    public ArrayList<WsssjlZkzmModel> getZkzmModelist() {
        return this.zkzmModelist;
    }

    public void setZkzmModelist(ArrayList<WsssjlZkzmModel> zkzmModelist) {
        this.zkzmModelist = zkzmModelist;
    }
}

