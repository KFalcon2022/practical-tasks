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

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return brand.equals(((Car) o).brand) &&
                model.equals(((Car) o).model) &&
                color.equals(((Car) o).color) &&
                number == ((Car) o).number;
    }

    public String compareCars(Car[] cars) {
        for (Car c : cars) {
            if (c.equals(this)) {
                System.out.println("The car is in the database");
                return c.toString();
            }
        }
        return "The car is not in the database";
    }

    @Override
    public String toString() {
        return ("Car brand: " + brand + "\nCar model: " + model + "\nCar color: " + color + "\nCar number: " + number);
    }
}
