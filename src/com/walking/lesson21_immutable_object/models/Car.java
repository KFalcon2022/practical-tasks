package com.walking.lesson21_immutable_object.models;

public class Car {
    private final String VIN;
    private final String plateNumber;
    private final CarSpecification carSpecification;
    //Хеш-код не будет меняться, поэтому для усокрения рассчитаем его сразу
    private final int hashCode;
    public Car(CarSpecification carSpecification, String VIN, String plateNumber) {
        this.carSpecification = carSpecification;
        this.VIN = VIN;
        this.plateNumber = plateNumber;
        hashCode = hashCode();
        if (!carSpecification.getBrandName().equals("Test")) {
            System.out.println("Car " + plateNumber + " is registered. VIN: " + VIN);
        }
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
        carSpecification.displaySpecs();
        return "\n"+"VIN: "+VIN+"\n"+"Plate number: "+plateNumber;
    }
}
