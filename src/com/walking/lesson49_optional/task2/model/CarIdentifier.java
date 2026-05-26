package com.walking.lesson49_optional.task2.model;

public class CarIdentifier implements Comparable<CarIdentifier> {
    private final String number;
    private final int releaseYear;

    public CarIdentifier(String number, int year) {
        this.number = number;
        releaseYear = year;
    }

    @Override
    public int compareTo(CarIdentifier o) {
        int result = releaseYear - o.releaseYear;
        if (result == 0) {
            result = number.compareTo(o.number);
        }
        return result;
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }

        if (car == null) {
            return false;
        }

        if (!getClass().equals(car.getClass())) {
            return false;
        }

        CarIdentifier c = (CarIdentifier) car;

        return number.equals(c.number) && releaseYear == c.releaseYear;
    }

    @Override
    public int hashCode() {
        return releaseYear * 31 + (number != null ? number.hashCode() : 0);
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getNumber() {
        return number;
    }

}
