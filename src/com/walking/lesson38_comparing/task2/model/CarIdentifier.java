package com.walking.lesson38_comparing.task2.model;

public final class CarIdentifier implements Comparable<CarIdentifier> {
    private final String brand;
    private final String number;

    public CarIdentifier(String brand, String number) {
        this.brand = brand;
        this.number = number;
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

    @Override
    public int compareTo(CarIdentifier o) {
        int result = brand.compareTo(o.brand);
        if (result == 0) {
            result = number.compareTo(o.number);
        }
        return result;
    }
}
