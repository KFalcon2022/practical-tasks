package com.walking.lesson19_object_methods.autos;

public class Car {
    private final String brand;
    private final String owner;
    private final String number;

    public Car(String brand, String owner, String number) {
        this.brand = brand;
        this.owner = owner;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Машина марки " + brand + ", владелец: " + owner + ", номер: " + number;
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }

        if (car == null) {
            return false;
        }

        if (!getClass().equals(car.getClass())) {
            return false;
        }

        Car auto = (Car) car;

        return number.equals(auto.number) && brand.equals(auto.brand) && owner.equals(auto.owner);
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result *= 31 + (owner != null ? owner.hashCode() : 0);
        result *= 31 + (number != null ? number.hashCode() : 0);

        return result;
    }

}
