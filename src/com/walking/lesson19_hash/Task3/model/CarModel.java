package com.walking.lesson19_hash.Task3.model;

public enum CarModel {
    LADA_SEDAN("Lada Sedan"),
    FORD_FOCUS("Ford Focus"),
    MERCEDES_BENZ("Mercedes Benz"),
    KIA_RIO("Kia Rio"),
    PEUGEOUT_BOXER("Peugeot Boxer"),
    RENAULT_LOGAN("Renault Logan"),
    TOYOTA_COROLLA("Toyota Corolla");
    
    private String modelName;
    
    CarModel(String name) {
        this.modelName = name;
    }
    
    public String getName() {
        return this.modelName;
    }
    
    
}