package com.walking.lesson61_synchronized.model;

public class Car {
    private final CarIdentificator carIdentificator;
    private String color;
    private final int hashcode;

    public Car(CarIdentificator carIdentificator, String color) {
        this.carIdentificator = carIdentificator;
        this.color = color;
        hashcode = hashCode();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarIdentificator getCarIdentificator() {
        return carIdentificator;
    }

    @Override
    public String toString() {
        return """
                \nPlate number: %s | Release year: %d | Color: %s""".formatted(
                carIdentificator.getPlateNumber(),
                carIdentificator.getReleaseYear(),
                color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        Car car = (Car) obj;

        return this.carIdentificator.equals(car.carIdentificator);
    }

    @Override
    public int hashCode() {
        if (hashcode == 0) {
            int hashcode = carIdentificator.hashCode();
            hashcode += 32 * hashcode;

            return hashcode;
        }
        return hashcode;
    }
}
