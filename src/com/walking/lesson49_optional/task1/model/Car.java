package com.walking.lesson49_optional.task1.model;

public class Car {
    private final CarIdentifier identifier;
    private String owner;
    private String color;

    public Car(CarIdentifier identifier) {
        this.identifier = identifier;
    }

    public Car(CarIdentifier identifier, String owner, String color) {
        this.identifier = identifier;
        this.owner = owner;
        this.color = color;
    }

    public Car(String brand, String number, String owner, String color) {
        this.identifier = new CarIdentifier(number, brand);
        this.owner = owner;
        this.color = color;
    }

    public String getInfo() {
        return "Машина марки %s, номер: %s, цвет: %s, владелец: %s"
                .formatted(identifier.getBrand(),
                        identifier.getNumber(),
                        color,
                        owner);
    }

    public void printInfo() {
        System.out.println(getInfo());
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
