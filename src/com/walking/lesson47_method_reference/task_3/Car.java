package com.walking.lesson47_method_reference.task_3;

public final class Car {
    private final String brand;         // brand is unique among other car manufacturers
    private final int serialNumber;     // SN is unique within a single manufacturer

    private final String model;
    private final int yearOfProduced;

    private int hashCode;

    public Car(String brand, String model, int yearOfProduced, int serialNumber) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduced = yearOfProduced;
        this.serialNumber = serialNumber;
        this.hashCode = hashCode();
    }

    public String getBrand() {
        return brand;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduced() {
        return yearOfProduced;
    }

    public int getHashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return String.format("Car {%s %s, %d, %d}", brand, model, yearOfProduced, serialNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        return serialNumber == car.serialNumber && brand.equals(car.brand);
    }

    @Override
    public int hashCode() {
        if (this.hashCode == 0) {
            int result = 1;
            result = 31 * result + serialNumber;
            result = 31 * result + (brand == null ? 0 : brand.hashCode());
            this.hashCode = result;
        }

        return this.hashCode;
    }
}
