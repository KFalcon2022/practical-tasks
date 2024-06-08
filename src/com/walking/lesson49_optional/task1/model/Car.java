package com.walking.lesson49_optional.task1.model;

public class Car {
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

    public CarIdentifier getCarIdentifier() {
        return carIdentifier;
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
        return "%s; %d; %s; %s".formatted(carIdentifier.getNumber(),
                carIdentifier.getYear(), color, actualTechnicalInspection ?
                        "actual" : "no actual");
    }
}
