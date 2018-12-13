package model;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class WsCpjgssfjeModel {
    private String value;
    private String category;

    public WsCpjgssfjeModel() {
    }

    public WsCpjgssfjeModel(String value, String category) {
        this.value = value;
        this.category = category;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

