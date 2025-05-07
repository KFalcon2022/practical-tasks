package com.walking.lesson49_optional.task2.model.Car;

import com.walking.lesson49_optional.task2.model.Human;

public class Car {
    private final CarIdenty identy;
    private Human owner;
    private String color;
    private boolean actualTech;

    public Car(String number, int year, Human owner, String color, boolean actualTech) {
        this.identy = new CarIdenty(number, year);
        this.owner = owner;
        this.color = color;
        this.actualTech = actualTech;
    }

    public Car(CarIdenty identy, Human owner, String color, boolean actualTech) {
        this.identy = identy;
        this.owner = owner;
        this.color = color;
        this.actualTech = actualTech;
    }

    public CarIdenty getIdenty() {
        return identy;
    }

    public Human getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }

    public boolean isActualTech() {
        return actualTech;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setActualTech(boolean actualTech) {
        this.actualTech = actualTech;
    }

    @Override
    public String toString() {
        return String.format("""
                number: %s,
                year: %d,
                color: %s,
                owner: %s;
                actualTechnicalInspection: %s""",
                identy.getNumber(),
                identy.getYear(),
                color,
                owner,
                actualTech);
    }
}
