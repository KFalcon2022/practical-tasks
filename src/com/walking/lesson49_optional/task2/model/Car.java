package com.walking.lesson49_optional.task2.model;

public class Car {
    private final CarIdentifier identifier;
    private Human owner;

    public Car(CarIdentifier identifier) {
        this.identifier = identifier;
    }

    public Car(CarIdentifier identifier, Human owner) {
        this.identifier = identifier;
        this.owner = owner;
    }

    public Car(int year, String number, Human owner) {
        this.identifier = new CarIdentifier(number, year);
        this.owner = owner;
    }

    public String getInfo() {
        return "Год выпуска: %s, номер: %s, владелец: %s"
                .formatted(identifier.getReleaseYear(),
                        identifier.getNumber(),
                        owner.getName());
    }

    public void printInfo() {
        System.out.println(getInfo());
    }

    public CarIdentifier getIdentifier() {
        return identifier;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }
}
