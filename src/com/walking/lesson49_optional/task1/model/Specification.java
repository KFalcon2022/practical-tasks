package com.walking.lesson49_optional.task1.model;

public final class Specification {
    private final String brand;
    private final String model;
    private final int year;
    
    public Specification(String brand, String model, int year){
        this.brand=brand;
        this.model=model;
        this.year=year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear(){
        return year;
    }
}