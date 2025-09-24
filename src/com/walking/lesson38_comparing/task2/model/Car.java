package com.walking.lesson38_comparing.task2.model;

public class Car implements Comparable<Car> {
    private final CarIdentifier identifier;
    private String owner;

    public Car(String brand, String owner, String number) {
        this.identifier = new CarIdentifier(brand, number);
        this.owner = owner;
    }

    public Car(CarIdentifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier.getBrand() + ", " + owner + ", " + identifier.getNumber();
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

    @Override
    public int compareTo(Car o) {
        return identifier.compareTo(o.identifier);
    }
}
