package com.walking.lesson31.Task1.model;

import java.io.Serializable;

public enum CarModel implements Serializable {
    NONE("", ""),
    LADA_SEDAN("Lada", "Sedan"),
    FORD_FOCUS("Ford", "Focus"),
    MERCEDES_BENZ("Mercedes", "Benz"),
    KIA_RIO("Kia", "Rio"),
    PEUGEOUT_BOXER("Peugeot", "Boxer"),
    RENAULT_LOGAN("Renault", "Logan"),
    TOYOTA_COROLLA("Toyota", "Corolla");
    
    private String brandName;
    private String modelName;
    
    CarModel(String brand, String model) {
        this.brandName = brand;
        this.modelName = model;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getFullName() {
        return this.brandName + " " + this.modelName;
    }

    public static CarModel validate(String brand, String model){
        try {
            return CarModel.valueOf(brand.toUpperCase() + "_" + model.toUpperCase());
        } catch (IllegalArgumentException e) {
            return CarModel.NONE;
        }
    }
}