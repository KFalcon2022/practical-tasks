package com.walking.lesson43_map.task2.model;

public class CarIdentifier implements Comparable<CarIdentifier> {
    private final String number;
    private final String brand;

    public CarIdentifier(String number, String brand) {
        this.number = number;
        this.brand = brand;
    }

    @Override
    public int compareTo(CarIdentifier o) {
        int result = brand.compareTo(o.brand);
        if (result == 0) {
            result = number.compareTo(o.number);
        }
        return result;
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

        CarIdentifier c = (CarIdentifier) car;

        return number.equals(c.number) && brand.equals(c.brand);
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result *= 31 + (number != null ? number.hashCode() : 0);

        return result;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }
}
