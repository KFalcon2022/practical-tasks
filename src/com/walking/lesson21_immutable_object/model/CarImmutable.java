package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public final class CarImmutable {
    private final String govNumber;
    private final String mark;

    public CarImmutable(String govNumber, String mark) {
        this.govNumber = govNumber;
        this.mark = mark;
    }

    public String getGovNumber() {
        return govNumber;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarImmutable that = (CarImmutable) o;

        if (!govNumber.equals(that.govNumber)) return false;
        return mark.equals(that.mark);
    }

    @Override
    public int hashCode() {
        int result = govNumber.hashCode();
        result = 31 * result + mark.hashCode();
        return result;
    }
}
