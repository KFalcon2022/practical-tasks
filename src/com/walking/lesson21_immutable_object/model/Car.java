package com.walking.lesson21_immutable_object.model;

public final class Car {
    private final CarImmutable id;
    private String color;


    public Car(String govNumber, String color, String mark){
        this.color = color;
        this.id = new CarImmutable(govNumber,mark);
    }

    public String getGovNumber() {
        return id.getGovNumber();
    }

    public CarImmutable getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getMark() {
        return id.getMark();
    }

    public String toSting(){
        return getColor() + " " + getMark() + " " + getGovNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
