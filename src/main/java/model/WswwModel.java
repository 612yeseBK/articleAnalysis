package model;

import java.util.HashMap;

/**
 * description:文尾
 * Created by gaoyw on 2018/12/10.
 */
public class WswwModel {
    private HashMap<String, String> spzzcyMap;
    private String wsrq = null;
    private String year;
    private String month;
    private String day;
    private String yearAndMonth;

    public WswwModel() {
    }

    public HashMap<String, String> getSpzzcyMap() {
        return this.spzzcyMap;
    }

    public void setSpzzcyMap(HashMap<String, String> spzzcyMap) {
        this.spzzcyMap = spzzcyMap;
    }

    public String getWsrq() {
        return this.wsrq;
    }

    public void setWsrq(String wsrq) {
        this.wsrq = wsrq;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYearAndMonth() {
        return this.yearAndMonth;
    }

    public void setYearAndMonth(String yearAndMonth) {
        this.yearAndMonth = yearAndMonth;
    }
}
