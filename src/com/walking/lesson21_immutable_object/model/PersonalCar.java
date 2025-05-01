package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public final class PersonalCar extends Car {
    private final String number;
    private final int year;
    private final int hashcode;

    public PersonalCar(String number, int year, String color, boolean actualTechnicalInspection) {
        super(color, actualTechnicalInspection);
        this.number = number;
        this.year = year;
        this.hashcode = hashCode();
    }

    public String getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public int getHashcode() {
        return hashcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !getClass().equals(o.getClass())) {
            return false;
        }

        PersonalCar car = (PersonalCar) o;

        return year == car.year && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        int hashcode = number.hashCode();
        hashcode += 31 * year;

        return hashcode;
    }

    @Override
    public String toString() {
        return """
                number: %s
                color: %s
                year: %d
                actualTechnicalInspection: %s
                """.formatted(number, getColor(), year, isActualTechnicalInspection() ? "actual" : "notActual");
    }
}
