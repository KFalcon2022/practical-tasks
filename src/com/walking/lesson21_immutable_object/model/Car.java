package com.walking.lesson21_immutable_object.model;

public class Car {
    private final IdentityCar identityCar;
    private ColorList color;

    public Car(IdentityCar identityCar, ColorList color) {
        this.identityCar = identityCar;
        this.color = color;
    }

    public Car(MarkList mark, ColorList color, int year, int stateNumber) {
        this.identityCar = new IdentityCar(mark, year, stateNumber);
        this.color = color;
    }

    public IdentityCar getIdentityCar() {
        return identityCar;
    }

    public ColorList getColor() {
        return color;
    }

    public void setColor(ColorList color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Машина: " + getIdentityCar().getMark() +
                " цвета " + color + ", " +
                getIdentityCar().getYear() + " года выпуска, гос.номер " +
                getIdentityCar().getStateNumber();

    }
}
