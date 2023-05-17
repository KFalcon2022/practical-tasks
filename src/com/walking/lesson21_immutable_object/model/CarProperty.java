package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public final class CarProperty{
    private final String number;
    private final String model;

    public CarProperty(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarProperty that = (CarProperty) o;
        return Objects.equals(number, that.number) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return number.hashCode() * 31  + model.hashCode();
    }

    @Override
    public String toString() {
        return "number=%s\nmodel=%s\n".formatted(number,model);
    }
}
