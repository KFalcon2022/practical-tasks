package com.walking.lesson21_immutable_object.car;

public class Car {
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
        return "Машина марки " + identifier.getBrand() + ", владелец: " + owner + ", номер: " + identifier.getNumber();
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
}
