package com.walking.lesson49_optional.task2.model;

// По аналогии с заменой CarSpecification на CarIdentificator
// реализую упрощенный класс Car по аналогии с автором курса
public class Car {
    private final CarIdentificator CAR_IDENTIFICATOR;
    private Citizen owner;
    private final String COLOR;
    public Car(CarIdentificator carIdentificator, String color, Citizen owner) {
        this.CAR_IDENTIFICATOR=carIdentificator;
        this.owner=owner;
        this.COLOR=color;
    }

    @Override
    public String toString() {
        return """
                \nPlate number: %s
                Release year: %d
                Owner: %s
                Color: %s""".formatted(
                        CAR_IDENTIFICATOR.getPlateNumber(),
                        CAR_IDENTIFICATOR.getReleaseYear(),
                        owner,
                        COLOR);
    }

    public CarIdentificator getCarIdentificator() {
        return CAR_IDENTIFICATOR;
    }

    public Citizen getOwner() {
        return owner;
    }
}
