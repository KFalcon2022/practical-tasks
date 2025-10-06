package com.walking.lesson21_immutable_object.cars;

import java.util.Objects;

public class Car {
    private String vin;
    private String number;
    private final CarImmutable carImmutable;

    public Car(String brand, String vin, int year, String carDrive, String transmission, double engineCapacity, String number) {
        this.carImmutable = new CarImmutable(brand, year, carDrive, transmission, engineCapacity);
        this.vin = vin;
        this.number = number;
    }




    @Override
    public String toString() {
        return "Найдена машина: " +
                "brand='" + carImmutable.getBrand() + '\'' +
                ", vin='" + vin + '\'' +
                ", year=" + carImmutable.getYear() +
                ", carDrive='" + carImmutable.getCarDrive() + '\'' +
                ", transmission='" + carImmutable.getTransmission() + '\'' +
                ", engineCapacity=" + carImmutable.getEngineCapacity() +
                ", number='" + number + '\'';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVin() {
        return vin;
    }


    public CarImmutable getCarImmutable() {
        return carImmutable;
    }
}
