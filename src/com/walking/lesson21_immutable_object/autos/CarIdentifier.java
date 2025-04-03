package com.walking.lesson21_immutable_object.autos;

public final class CarIdentifier {
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

        CarIdentifier auto = (CarIdentifier) car;

        return number.equals(auto.number) && brand.equals(auto.brand);
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
