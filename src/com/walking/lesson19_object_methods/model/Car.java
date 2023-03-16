package com.walking.lesson19_object_methods.model;

public class Car {
    private String govNumber;
    private String color;
    private String mark;

    public Car(String govNumber, String color, String mark){
        this.color = color;
        this.mark = mark;
        this.govNumber = govNumber;
    }

    public String getGovNumber() {
        return govNumber;
    }

    public String getColor() {
        return color;
    }

    public String getMark() {
        return mark;
    }

    public String toSting(){
        return getColor() + " " + getMark() + " " + getGovNumber();
    }
}
