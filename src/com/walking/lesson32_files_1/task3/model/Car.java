package com.walking.lesson32_files_1.task3.model;

public class Car {
    private final String mark;
    private String color;
    private final int yearManufacture;
    private final int stateNumber;


    public Car(String mark, String color, int yearManufacture, int stateNumber) {
        this.mark = mark;
        this.color = color;
        this.yearManufacture = yearManufacture;
        this.stateNumber = stateNumber;
    }

    public String getMark() {
        return mark;
    }

    public String getColor() {
        return color;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public int getStateNumber() {
        return stateNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * (yearManufacture + result);
        result += stateNumber + result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Car car = (Car) obj;

        return mark.equals(car.mark) && stateNumber == car.stateNumber && yearManufacture == car.yearManufacture;

    }

    @Override
    public String toString() {
        return mark + " цвета " + color + ", " + yearManufacture + " года выпуска, гос.номер " + stateNumber + ";\n";
    }
}
