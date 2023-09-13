package com.walking.lesson19_object_methods.model;

public class Car {
    private final String mark;
    private final int yearOfManufacture;
    private final String color;
    private final String stateNumber;


    public Car() {
        this.mark = new Mark().setMark();
        this.yearOfManufacture = new YearOfManufacture().setYearOfManufacture();
        this.color = new Color().setColor();
        this.stateNumber = new StateNumber().setStateNumber();
    }

    public Car(String mark, int yearOfManufacture, String color, String stateNumber) {
        this.mark = mark;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.stateNumber = stateNumber;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 22 * (yearOfManufacture + result);
        result = 5 * (color != null ? color.hashCode() : 0);
        result = stateNumber != null ? stateNumber.hashCode() : 0;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!this.getClass().equals(obj)) return false;

        Car car = (Car) obj;

        if (mark.equals(car.mark) && color.equals(car.color) && stateNumber.equals(car.stateNumber) && yearOfManufacture == car.yearOfManufacture) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return mark + " цвета " + color + ", " + yearOfManufacture + " года выпуска, гос.номер " + stateNumber;
    }
}
