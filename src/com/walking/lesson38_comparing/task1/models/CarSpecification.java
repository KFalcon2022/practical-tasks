package com.walking.lesson38_comparing.task1.models;

public final class CarSpecification {
    private final String brandName;
    private final String modelName;
    private final double zeroToHundred;
    private final VehicleType vehicleType;
    private final int hashCode;

    public CarSpecification (String brandName, String modelName, double zeroToHundred, VehicleType vehicleType){
        this.brandName=brandName;
        this.modelName=modelName;
        this.zeroToHundred=zeroToHundred;
        this.vehicleType=vehicleType;
        hashCode=hashCode();
    }
    public void displaySpecs(){
        System.out.println("Car brand: "+brandName);
        System.out.println("Car model: "+modelName);
        System.out.println("Car acceleration: "+zeroToHundred+" c");
        System.out.println("Vehicle type: "+vehicleType);
    }
    public String getBrandName(){
        return brandName;
    }
}
