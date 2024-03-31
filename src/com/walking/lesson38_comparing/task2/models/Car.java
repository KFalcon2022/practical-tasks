package com.walking.lesson38_comparing.task2.models;

public class Car implements Comparable<Car>{
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
        return this.plateNumber.equals(car.plateNumber) && this.VIN.equals(car.VIN);
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
        return "\n"+"VIN: "+VIN+"\n"+"Plate number: "+plateNumber+"\n";
    }
    public String getPlateNumber(){
        return plateNumber;
    }
    public String getVIN(){
        return VIN;
    }
    public CarSpecification getCarSpecification(){
        return carSpecification;
    }

    @Override
    public int compareTo(Car car) {
        int resultSpecification = getCarSpecification().compareTo(car.getCarSpecification());
        if (resultSpecification==0){
            return VIN.compareTo(car.getVIN());
        }
        return resultSpecification;
    }
}