package com.walking.lesson49_optional.task2.model.Car;

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

        return year == identy.getYear() && Objects.equals(number, identy.getNumber());
    }

    @Override
    public int hashCode() {
        int hashCode = number.hashCode();
        hashCode += 31 * year;

        return hashCode;
    }

    @Override
    public int compareTo(CarIdenty o) {
        if (number.compareTo(o.getNumber()) > 0) {
            return 1;
        } else if (number.compareTo(o.getNumber()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
