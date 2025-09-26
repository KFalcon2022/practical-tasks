package com.walking.lesson19_object_methods.cars;

import java.util.Objects;

public class Car {
    private final String brand;
    private final String vin;
    private final int year;
    private final String carDrive;
    private final String transmission;
    private final double engineCapacity;
    private String number;

    public Car(String brand, String vin, int year, String carDrive, String transmission, double engineCapacity, String number) {
        this.brand = brand;
        this.vin = vin;
        this.year = year;
        this.carDrive = carDrive;
        this.transmission = transmission;
        this.engineCapacity = engineCapacity;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Double.compare(engineCapacity, car.engineCapacity) == 0 && Objects.equals(brand, car.brand) && Objects.equals(vin, car.vin) && Objects.equals(carDrive, car.carDrive) && Objects.equals(transmission, car.transmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, vin, year, carDrive, transmission, engineCapacity);
    }

    @Override
    public String toString() {
        return "Найдена машина: " +
                "brand='" + brand + '\'' +
                ", vin='" + vin + '\'' +
                ", year=" + year +
                ", carDrive='" + carDrive + '\'' +
                ", transmission='" + transmission + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", number='" + number + '\'';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getCarDrive() {
        return carDrive;
    }

    public int getYear() {
        return year;
    }

    public String getVin() {
        return vin;
    }

    public String getBrand() {
        return brand;
    }
}
