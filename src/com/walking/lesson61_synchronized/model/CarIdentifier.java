package com.walking.lesson61_synchronized.model;

import java.util.Objects;

public class CarIdentifier {
    private final String number;
    private final int year;

    private final int hashcode;

    public CarIdentifier(String number, int year) {
        this.number = number;
        this.year = year;

        hashcode = hashCode();
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarIdentifier that = (CarIdentifier) o;

        return getYear() == that.getYear() && Objects.equals(getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {
        int hashcode = number.hashCode();
        hashcode += year * 31;
        return hashcode;
    }

}
