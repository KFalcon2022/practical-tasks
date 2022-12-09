package com.walking.lesson21_immutable_object.model;

public class Car {
    private final ImmutableCharacteristics ic;
    private String color;
    private int number;

    public Car(ImmutableCharacteristics ic, String color, int number) {
        this.ic = ic;
        this.color = color;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !(getClass().equals(o.getClass()))) {
            return false;
        }

        Car car = (Car) o;

        return ic.getModel().equals(car.ic.getModel()) &&
                ic.getBrand().equals(car.ic.getBrand()) &&
                color.equals(car.color) &&
                number == car.number;
    }

    @Override
    public String toString() {
        return ("Car brand: " + ic.getBrand() + "\nCar model: " + ic.getModel() + "\nCar color: " + color + "\nCar number: " + number);
    }
}
