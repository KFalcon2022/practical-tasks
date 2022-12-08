package com.walking.lesson19_object_methods;

public class Car {
    private final String brand;
    private final String model;
    private String color;
    private int number;

    public Car(String brand, String model, String color, int number) {
        this.brand = brand;
        this.model = model;
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

        return brand.equals(car.brand) &&
                model.equals(car.model) &&
                color.equals(car.color) &&
                number == car.number;
    }

    @Override
    public String toString() {
        return ("Car brand: " + brand + "\nCar model: " + model + "\nCar color: " + color + "\nCar number: " + number);
    }
}
