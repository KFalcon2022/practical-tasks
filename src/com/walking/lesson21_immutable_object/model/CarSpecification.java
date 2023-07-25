package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public final class CarSpecification {
    private final String brand;
    private final String model;
    private final String color;

    public CarSpecification(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "brand: %s, model: %s, color: %s".formatted(brand, model, color);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof CarSpecification)) {
            return false;
        }
        CarSpecification carSpecification = (CarSpecification) o;
        if (carSpecification.brand.equals(this.brand)
                && carSpecification.model.equals(this.model)
                && carSpecification.color.equals(this.color)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color);
    }
}
