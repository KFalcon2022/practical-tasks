package com.walking.lesson38_comparing.task2.model;


public final class IdentyCar {
    private final MarkType mark;
    private final int year;
    private final String stateNumber;


    public IdentyCar(MarkType mark, int year, String stateNumber) {
        this.mark = mark;
        this.year = year;
        this.stateNumber = stateNumber;
    }

    public MarkType getMark() {
        return mark;
    }

    public int getYear() {
        return year;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    @Override
    public int hashCode() {
        int result = stateNumber.hashCode();
        result += 31 * year;

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!this.getClass().equals(o.getClass())) {
            return false;
        }

        IdentyCar car = (IdentyCar) o;

        return year == car.year && stateNumber.equals(car.stateNumber);
    }

    public int compareTo(IdentyCar identyCar) {
        if (stateNumber.compareTo(identyCar.getStateNumber()) > 0) {
            return 1;
        } else if (stateNumber.compareTo(identyCar.getStateNumber()) < 0) {
            return -1;
        } else {
            return year - identyCar.getYear();
        }
    }
}
