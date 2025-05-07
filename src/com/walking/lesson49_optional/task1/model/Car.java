package com.walking.lesson49_optional.task1.model;

public class Car {
    private final CarIdenty identy;

    private String color;
    private boolean actualTechnicalInspection;

    public Car(String number, int year, String color, boolean actualTechnicalInspection) {
        this.identy = new CarIdenty(number, year);
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    public Car(CarIdenty identy, String color, boolean actualTechnicalInspection) {
        this.identy = identy;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    public CarIdenty getIdenty() {
        return identy;
    }

    public String getColor() {
        return color;
    }

    public boolean isActualTechnicalInspection() {
        return actualTechnicalInspection;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setActualTechnicalInspection(boolean actualTechnicalInspection) {
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    @Override
    public String toString() {
        return String.format("""
                number: %s,
                year: %d,
                color: %s,
                actualTechnicalInspection: %s""",
                identy.getNumber(),
                identy.getYear(),
                color,
                actualTechnicalInspection ? "actual" : "not actual");
    }
}
