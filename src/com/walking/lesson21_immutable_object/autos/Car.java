package com.walking.lesson21_immutable_object.autos;

public class Car {
    private final CarIdentifier identifier;
    private String owner;

    public Car(String brand, String owner, String number) {
        this.identifier = new CarIdentifier(brand, number);
        this.owner = owner;
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

}
