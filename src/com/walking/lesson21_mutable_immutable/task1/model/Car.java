package com.walking.lesson21_mutable_immutable.task1.model;

public final class Car {
    public String color = "White";
    private int maxSpeed = 5;
    public final Brand BRAND;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Car(Brand brand) {
        this.maxSpeed = maxSpeed;
        this.color = "Black";
        this.BRAND = brand;
    }

    public Car(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        this.color = "Black";
        this.BRAND = Brand.TOYOTA;
    }

    public Car(String color) {
        this.color = color;
        this.maxSpeed = 20;
        this.BRAND=Brand.TOYOTA;
    }

    public Car(String color, int maxSpeed) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.BRAND = Brand.KIA;
    }

    public Car(String color, int maxSpeed, Brand brand) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.BRAND = brand;
    }

    @Override
    public boolean equals(Object o) { //Сравнение обектов на совпадение классов, не пустое значениеи полей цвета и скорости
        if (o == null) {
            System.out.println("o==null");
            return false;
        }
        if (!getClass().equals(o.getClass())) {
            System.out.println("!getClass().equals(o.getClass())");
            return false;
        }
        Car p = (Car) o;

        if (!this.color.equals(p.color)) {
            return false;
        }
        return this.maxSpeed == p.maxSpeed;
    }
    @Override
    public int hashCode(){

        return 10 * color.hashCode() + 20*maxSpeed;
    }
}
