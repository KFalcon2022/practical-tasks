package com.walking.lesson19_object_methods.model;

import java.util.Objects;

public class Car {
    private String registrationPlate;
    private String brand;
    private String model;
    private int year;
    private String color;

    public Car(String registrationPlate, String brand, String model, int year, String color) {
        this.registrationPlate = registrationPlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public int hashCode() {
        int result = this.registrationPlate == null ? 0 : this.registrationPlate.hashCode();
        result = 31 * result + (this.brand == null ? 0 : this.brand.hashCode());
        result = 31 * result + (this.model == null ? 0 : this.model.hashCode());
        result = 31 * result + this.year;
        result = 31 * result + (this.color == null ? 0 : this.color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(registrationPlate, car.registrationPlate) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && (year == car.year) && Objects.equals(color, car.color);
    }

    @Override
    public String toString() {
        return "Car(registration plate - " + registrationPlate + ", brand - " + brand + ", model - " + model + ", year - " + year + ", color - " + color + ")";
    }
}
