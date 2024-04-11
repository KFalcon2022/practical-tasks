package com.walking.lesson19_object_methods.model;

import java.util.Objects;

public class Car {
    private final String color;
    private final String brand;
    private final String number;
    private final String VIN_number;
    private final int carHashCode = hashCode();

    public Car(String color, String brand, String number, String VIN_number) {
        this.color = color;
        this.brand = brand;
        this.number = number;
        this.VIN_number = VIN_number;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color) && Objects.equals(brand, car.brand) && Objects.equals(number, car.number) && Objects.equals(VIN_number, car.VIN_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, brand, number, VIN_number);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", number='" + number + '\'' +
                ", VIN_number='" + VIN_number + '\'' +
                '}';
    }

    public boolean searchCar(Car searchingCar) {
            return this.equals(searchingCar) && carHashCode == searchingCar.carHashCode;
    }
}
