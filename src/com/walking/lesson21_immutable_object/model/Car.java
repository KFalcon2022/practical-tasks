package com.walking.lesson21_immutable_object.model;

public final class Car {
    private  String registrationNumber;
    private String color;
    private final String brand;
    private final String model;
    private final int yearCar;
    private final String vin;

    private final int hashcode;

    public Car(String regNumb, String color,String brand, String model, int yearCar, String vin) {
        this.registrationNumber = regNumb;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.yearCar = yearCar;
        this.vin = vin;
        hashcode = hashCode();
    }

    public int getHashcode() {
        return hashcode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
                    && this.model == car.model
                    && this.color == color) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
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
