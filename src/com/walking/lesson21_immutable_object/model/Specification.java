package com.walking.lesson21_immutable_object.model;

public final class Specification {
    private final String brand;
    private final String model;
    
    public Specification(String brand, String model){
        this.brand=brand;
        this.model=model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
