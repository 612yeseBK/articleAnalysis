package template.model.BaseModel;

import java.util.*;

/**
 * description:基本模板 -- 文尾部分
 * Created by gaoyw on 2018/12/17.
 */
public class BaseWWModel {
    private HashMap<String, String> spzzcyMap;  //审判组织成员
    private String cpsj = null;  //裁判时间
    private String year;  //年
    private String month;  //月
    private String day;  //日
    private String yearAndMonth;  //年月

    public HashMap<String, String> getSpzzcyMap() {
        return spzzcyMap;
    }

    public void setSpzzcyMap(HashMap<String, String> spzzcyMap) {
        this.spzzcyMap = spzzcyMap;
    }

    public String getCpsj() {
        return cpsj;
    }

    public void setCpsj(String cpsj) {
        this.cpsj = cpsj;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYearAndMonth() {
        return yearAndMonth;
    }

    public void setYearAndMonth(String yearAndMonth) {
        this.yearAndMonth = yearAndMonth;
    }

    public String getMapContent(HashMap hashMap){
        String str = "";
        Set set = hashMap.keySet();
        for(Object o: set){
            String key = o.toString();
            str += key+":"+hashMap.get(key)+";";
        }
        return str;
    }

    @Override
    public String toString(){
        return getMapContent(spzzcyMap)+" cpsj:"+cpsj;
    }
}
