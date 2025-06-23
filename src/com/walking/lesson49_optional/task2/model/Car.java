package com.walking.lesson49_optional.task2.model;


public class Car {
    private final CarIdentifier identifier;

    private Person owner;
    private String color;
    private boolean actualTechnicalInspection;

    public Car(String number, int year, Person owner, String color, boolean actualTechnicalInspection) {
        this(new CarIdentifier(number, year), owner, color, actualTechnicalInspection);
    }

    public Car(CarIdentifier identifier, Person owner, String color, boolean actualTechnicalInspection) {
        this.identifier = identifier;
        this.owner = owner;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    public CarIdentifier getIdentifier() {
        return identifier;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActualTechnicalInspection() {
        return actualTechnicalInspection;
    }

    public void setActualTechnicalInspection(boolean actualTechnicalInspection) {
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    @Override
    public String toString() {
        return "number: %s | year: %d  | owner: %s | color: %s | actualTechnicalInspection: %s".formatted(identifier.getNumber(),
                identifier.getYear(), owner.getName(), color, actualTechnicalInspection ? "actual" : "not actual");
    }
}