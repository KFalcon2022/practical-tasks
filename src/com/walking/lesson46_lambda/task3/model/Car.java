package com.walking.lesson46_lambda.task3.model;

public class Car {
    private final CarIdentifier identifier;
    private String owner;
    private String color;
    private int releaseYear;

    public Car(String brand, String owner, String number, String color, int releaseYear) {
        this.identifier = new CarIdentifier(brand, number);
        this.owner = owner;
        this.color = color;
        this.releaseYear = releaseYear;
    }

    public Car(CarIdentifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "%s, %s, %s, %s, %d.".formatted(identifier.getBrand(), identifier.getNumber(), owner, color, releaseYear);
    }

    public CarIdentifier getIdentifier() {
        return identifier;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

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

        Car c = (Car) car;

        return identifier.equals(c.identifier);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
