package com.walking.lesson38_comparing.task2.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class CarIdentifier implements Comparable<CarIdentifier> {

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

    @Override
    public int compareTo(@NotNull CarIdentifier o) {
        int result = number.compareTo(o.getNumber());
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            if (year > o.getYear()) {
                return 1;
            }

            if (year < o.getYear()) {
                return -1;
            }
        }
        throw new RuntimeException("Cars are identical!");
    }
}
