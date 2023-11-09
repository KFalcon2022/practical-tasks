package com.walking.lesson32_files_1.task1.model;

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

    public Car (String [] stringsCar) {
        this.registrationNumber = stringsCar[0];
        this.brand = stringsCar[1];
        this.model = stringsCar[2];
        this.yearCar =  Integer.parseInt(stringsCar[3]);
        this.vin = stringsCar[4];
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
                "\nVIN: " + vin + "\n";
    }

    public int getYearCar() {
        return yearCar;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVin() {
        return vin;
    }
}
