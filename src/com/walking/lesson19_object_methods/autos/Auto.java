package com.walking.lesson19_object_methods.autos;

import java.util.Objects;

public class Auto {
    private final String make;
    private final String owner;
    private final String number;

    public Auto(String make, String owner, String number) {
        this.make = make;
        this.owner = owner;
        this.number = number;
    }

    public Auto findAuto(Auto[] autos) {
        for (Auto auto : autos) {
            if (this.equals(auto)) {
                return auto;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Машина марки " + make + ", владелец: " + owner + ", номер: " + number;
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

        Auto auto = (Auto) car;
        if (!this.make.equals(auto.make)) {
            return false;
        }
        if (!this.owner.equals(auto.owner)) {
            return false;
        }

        return this.number.equals(auto.number);
    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 11 * result + (owner != null ? owner.hashCode() : 0);
        result = 11 * result + (number != null ? number.hashCode() : 0);

        return result;
    }

}
