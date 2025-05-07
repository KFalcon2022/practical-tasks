package com.walking.lesson38_comparing.task2.model;

import java.util.Objects;

public class CarIdentifier {
    private final String number;
    private final int year;

    public CarIdentifier(String number, int year) {
        this.number = number;
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !getClass().equals(o.getClass())) {
            return false;
        }

        CarIdentifier identifier = (CarIdentifier) o;

        return year == identifier.year && Objects.equals(number, identifier.number);
    }

    @Override
    public int hashCode() {
        int hashcode = number.hashCode();
        hashcode += 31 * year;

        return hashcode;
    }
}
