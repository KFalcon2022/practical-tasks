package com.walking.lesson38_comparing.task2.model;

public class Car implements Comparable<Car> {
    private final CarIdentifier carIdentifier;

    private String color;
    private boolean actualTechnicalInspection;


    public Car(String number, int year, String color, boolean actualTechnicalInspection) {
        this(new CarIdentifier(number, year), color, actualTechnicalInspection);
    }

    public Car(CarIdentifier carIdentifier, String color, boolean actualTechnicalInspection) {
        this.carIdentifier = carIdentifier;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    @Override
    public String toString() {
        return "number: %s year: %d color: %s actualTechnicalInspection: %s".formatted(
                carIdentifier.getNumber(),
                carIdentifier.getYear(), color,
                actualTechnicalInspection ? "actual" : "not actual");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setActualTechnicalInspection(boolean actualTechnicalInspection) {
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    public CarIdentifier getCarIdentifier() {
        return carIdentifier;
    }

    public String getColor() {
        return color;
    }

    public boolean isActualTechnicalInspection() {
        return actualTechnicalInspection;
    }

    @Override
    public int compareTo(Car o) {
        return carIdentifier.compareTo(o.carIdentifier);
    }
}
