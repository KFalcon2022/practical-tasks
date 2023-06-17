package com.walking.lesson19_object_methods.model;

import java.util.Objects;

public class Car {
    private String registrationNumber;
    private String brand;
    private String model;
    private int yearCar;
    private String vin;

    public Car(String regNumb, String brand, String model, int yearCar, String vin) {
        this.registrationNumber = regNumb;
        this.brand = brand;
        this.model = model;
        this.yearCar = yearCar;
        this.vin = vin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        if (obj instanceof Car car) {
            if (this.vin == car.vin
                    && this.yearCar == car.yearCar
                    && this.brand == car.brand
                    && this.registrationNumber == car.registrationNumber
                    && this.model == car.model) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = registrationNumber != null ? registrationNumber.hashCode() : 0;
        result = 31 * result + ( brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (yearCar != 0 ? yearCar : 0);
        result = 31 * result + (vin != null ? vin.hashCode() : 0);
        return result;
    }

    public String toString()
    {
        return "Регистрационный номер: " + registrationNumber +
                "\nМарка автомобиля: " + brand +
                "\nМодель автомобиля: " + model +
                "\nГод выпуска автомобиля: " + yearCar +
                "\nVIN: " + vin;
    }
}
