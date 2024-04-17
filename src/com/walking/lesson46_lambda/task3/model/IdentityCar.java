package com.walking.lesson46_lambda.task3.model;

public final class IdentityCar {
    private final MarkType mark;
    private final int year;
    private final int stateNumber;


    public IdentityCar(MarkType mark, int year, int stateNumber) {
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

    public int getStateNumber() {
        return stateNumber;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result += 31 * (year + result);
        result += 31 * (stateNumber + result);
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

        IdentityCar car = (IdentityCar) o;

        return mark.equals(car.mark) && year == car.year && stateNumber == car.stateNumber;
    }
}
