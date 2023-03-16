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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!govNumber.equals(car.govNumber)) return false;
        if (!color.equals(car.color)) return false;
        return mark.equals(car.mark);
    }

    @Override
    public int hashCode() {
        int result = govNumber.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + mark.hashCode();
        return result;
    }
}
