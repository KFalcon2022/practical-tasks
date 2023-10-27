package com.walking.lesson38_comparing.task1.model;

public class Car {
    private final IdentyCar identyCar;
    private ColorType color;

    public Car(IdentyCar identityCar, ColorType color) {
        this.identyCar = identityCar;
        this.color = color;
    }

    public Car(MarkType mark, ColorType color, int year, String stateNumber) {
        this.identyCar = new IdentyCar(mark, year, stateNumber);
        this.color = color;
    }

    public IdentyCar getIdentityCar() {
        return identyCar;
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
