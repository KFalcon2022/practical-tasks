package com.walking.lesson49_optional.task2.model.car;

import com.walking.lesson49_optional.task2.model.Human;

public class Car {
    //    Уникальным идентификатором будет объект immutable класса CarIdentifier
    private final CarIdentifier identifier;

    private String color;
    private boolean actualTechnicalInspection;
    private Human owner;

    public Car(String number, int year, String color, boolean actualTechnicalInspection, Human owner) {
        this(new CarIdentifier(number, year), color, actualTechnicalInspection, owner);
    }

    public Car(CarIdentifier identifier, String color, boolean actualTechnicalInspection, Human owner) {
        this.identifier = identifier;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
        this.owner = owner;
    }

    public CarIdentifier getIdentifier() {
        return identifier;
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

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
//        Метод formatted() у String позволяет создать строку с использованием спецификаторов
//        (как в System.out.printf()). До Java 15 вместо него использовался статический метод String.format().
//        Здесь он использован для большей наглядности кода, менее красиво, но с тем же успехом,
//        можно было обойтись обычной конкатенацией строк
        return """
                number: %s
                year: %d
                color: %s
                actualTechnicalInspection: %s
                owner: %s
                """.formatted(
                identifier.getNumber(), identifier.getYear(), color,
                actualTechnicalInspection ? "actual" : "not actual",
                owner.getName());
    }
}
