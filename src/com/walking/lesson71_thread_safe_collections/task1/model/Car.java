package com.walking.lesson71_thread_safe_collections.task1.model;

public class Car {
    private String vendor;
    private String model;
    private String color;
    private Integer year;

    public Car(String vendor, String model, String color, Integer year){
        this.vendor=vendor;
        this.model=model;
        this.color=color;
        this.year=year;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
}
