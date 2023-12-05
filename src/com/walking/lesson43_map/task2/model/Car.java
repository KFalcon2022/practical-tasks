package com.walking.lesson43_map.task2.model;

public class Car {
    private final MarkType mark;
    private final ColorType color;
    private final int yearManufacture;
    private final int stateNumber;


    public Car(MarkType mark, ColorType color, int yearManufacture, int stateNumber) {
        this.mark = mark;
        this.color = color;
        this.yearManufacture = yearManufacture;
        this.stateNumber = stateNumber;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * (yearManufacture + result);
        result += 31 * (stateNumber + result);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }

        Car car = (Car) obj;

        return mark.equals(car.mark) && stateNumber == car.stateNumber && yearManufacture == car.yearManufacture;

    }

    @Override
    public String toString() {
        return mark + " цвета " + color + ", " + yearManufacture + " года выпуска, гос.номер " + stateNumber;
    }
}
