package model;

import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class QzcsModel {
    private String qzcsCategory;
    private String qzcsTime;
    private String qzcsDw;
    private List<String> qscsReason;
    private String isDB;
    private String DBTime;

    public QzcsModel() {
    }

    public String getDBTime() {
        return this.DBTime;
    }

    public void setDBTime(String DBTime) {
        this.DBTime = DBTime;
    }

    public String getIsDB() {
        return this.isDB;
    }

    public void setIsDB(String isDB) {
        this.isDB = isDB;
    }

    public String getQzcsCategory() {
        return this.qzcsCategory;
    }

    public void setQzcsCategory(String qzcsCategory) {
        this.qzcsCategory = qzcsCategory;
    }

    public String getQzcsTime() {
        return this.qzcsTime;
    }

    public void setQzcsTime(String qzcsTime) {
        this.qzcsTime = qzcsTime;
    }

    public String getQzcsDw() {
        return this.qzcsDw;
    }

    public void setQzcsDw(String qzcsDw) {
        this.qzcsDw = qzcsDw;
    }

    public List<String> getQscsReason() {
        return this.qscsReason;
    }

    public void setQscsReason(List<String> qscsReason) {
        this.qscsReason = qscsReason;
    }
}
