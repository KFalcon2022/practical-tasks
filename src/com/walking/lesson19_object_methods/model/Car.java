package com.walking.lesson19_object_methods.model;

public class Car {
    private final String brandName;
    private final String modelName;
    private final String VIN;
    private final String plateNumber;
    //Хеш-код не будет меняться, поэтому для усокрения рассчитаем его сразу
    private final int hashCode;
    public Car(String brandName, String modelName, String VIN, String plateNumber){
        this.brandName=brandName;
        this.modelName=modelName;
        this.VIN=VIN;
        this.plateNumber=plateNumber;
        hashCode=hashCode();
        if (!brandName.equals("Car for check"))
        System.out.println("Car "+plateNumber+" is registered. VIN: "+VIN);
    }
    @Override
    public boolean equals(Object obj){
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (!getClass().equals(obj.getClass()))
            return false;
        Car car = (Car) obj;
        if (this.plateNumber.equals(car.plateNumber)&& this.VIN.equals(car.VIN))
            return true;
        else return false;
    }
    @Override
    public int hashCode(){
        if (hashCode==0) {
            int result = plateNumber.hashCode();
            result += 31 + VIN.hashCode();
            return result;
        }
        else return hashCode;
    }
    @Override
    public String toString(){
        return "\n"+"Brand: "+brandName+"\n"+"Model: "+modelName+"\n"+"VIN: "+VIN+"\n"+"Plate number: "+plateNumber;
    }
}
