package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

final public class Car {
    final private String registrationPlate;
    final private String brand;
    final private String model;
    final private int year;

    public Car(String registrationPlate, String brand, String model, int year) {
        this.registrationPlate = registrationPlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public int hashCode() {
        int result = this.registrationPlate == null ? 0 : this.registrationPlate.hashCode();
        result = 31 * result + (this.brand == null ? 0 : this.brand.hashCode());
        result = 31 * result + (this.model == null ? 0 : this.model.hashCode());
        result = 31 * result + this.year;
        return result;
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
        return Objects.equals(registrationPlate, car.registrationPlate)
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model)
                && (year == car.year);
    }

    @Override
    public String toString() {
        return String.format("Car (registration plate:%s, brand:%s, model:%s, year:%d)", registrationPlate, brand, model, year);
    }
}
