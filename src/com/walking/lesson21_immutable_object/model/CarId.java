package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public final class CarId {
    private final String owner;
    private final int serialNumber;

    private int hashCode;

    public CarId(String owner, int serialNumber) {
        this.owner = owner;
        this.serialNumber = serialNumber;
        this.hashCode = hashCode();
    }

    public String getOwner() {
        return owner;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return """
                owner: %s
                serialNumber: %d
                """.formatted(owner, serialNumber);
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = owner.hashCode();
            hashCode += 31 * serialNumber;
        }

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }

        CarId carId = (CarId) obj;

        return serialNumber == carId.serialNumber && Objects.equals(owner, carId.owner);
    }
}
