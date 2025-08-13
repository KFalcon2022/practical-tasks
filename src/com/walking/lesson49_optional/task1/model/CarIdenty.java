package com.walking.lesson49_optional.task1.model;

import java.util.Objects;

public class CarIdenty implements Comparable<CarIdenty> {
    private final String number;
    private final int year;

    public CarIdenty(String number, int year) {
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

        CarIdenty identy = (CarIdenty) o;

        return year == identy.year && Objects.equals(number, identy.number);
    }

    @Override
    public int hashCode() {
        int hascode = number.hashCode();
        hascode += 31 * year;

        return hascode;
    }

    @Override
    public int compareTo(CarIdenty o) {
        if (number.compareTo(o.number) > 0) {
            return 1;
        }

        if (number.compareTo(o.number) < 0) {
            return -1;
        }

        return 0;
    }
}
