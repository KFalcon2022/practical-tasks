package com.walking.lesson21_immutable_object.model;

public class Car {
    private String color;
    private boolean actualTechnicalInspection;

    public Car(String color, boolean actualTechnicalInspection) {
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
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
        return """
                color: %s
                actualTechnicalInspection: %s
                """.formatted(color,
                actualTechnicalInspection ? "actual" : "not actual");
    }
}
