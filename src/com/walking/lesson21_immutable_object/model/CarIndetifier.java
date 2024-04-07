package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public final class CarIndetifier {
    private final String VIN_number;
    private final int hash = hashCode();

    public CarIndetifier(String vinNumber) {
        VIN_number = vinNumber;
    }

    public String getVIN_number() {
        return VIN_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarIndetifier that = (CarIndetifier) o;
        return Objects.equals(VIN_number, that.VIN_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VIN_number);
    }
}
