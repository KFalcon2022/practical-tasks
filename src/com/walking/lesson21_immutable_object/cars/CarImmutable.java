package com.walking.lesson21_immutable_object.cars;

import java.util.Objects;

public class CarImmutable {
    private final String brand;
    private final int year;
    private final String carDrive;
    private final String transmission;
    private final double engineCapacity;


    public CarImmutable(String brand, int year, String carDrive, String transmission, double engineCapacity) {
        this.brand = brand;
        this.year = year;
        this.carDrive = carDrive;
        this.transmission = transmission;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarImmutable car = (CarImmutable) o;
        return year == car.year && Double.compare(engineCapacity, car.engineCapacity) == 0 && Objects.equals(brand, car.brand) && Objects.equals(carDrive, car.carDrive) && Objects.equals(transmission, car.transmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, year, carDrive, transmission, engineCapacity);
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

    public String getBrand() {
        return brand;
    }
}
