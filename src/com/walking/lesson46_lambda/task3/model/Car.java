package com.walking.lesson46_lambda.task3.model;

public class Car {
    private final IdentityCar identityCar;
    private ColorType color;

    public Car(IdentityCar identityCar, ColorType color) {
        this.identityCar = identityCar;
        this.color = color;
    }

    public Car(MarkType mark, ColorType color, int year, int stateNumber) {
        this.identityCar = new IdentityCar(mark, year, stateNumber);
        this.color = color;
    }

    public IdentityCar getIdentityCar() {
        return identityCar;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
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
