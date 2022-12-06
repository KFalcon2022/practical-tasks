package com.walking.lesson19_object_methods;


public class Car {
    private String carColor;
    private String engineNumber;
    private String regNumber;
    private String mileage;

    Car (String regNumber, String engineNumber, String carColor) {
        this(regNumber, engineNumber, carColor, "000000");
    }

    Car (String regNumber, String engineNumber, String carColor, String mileage) {
        this.carColor = carColor;
        this.engineNumber = engineNumber;
        this.regNumber = regNumber;
        this.mileage = mileage;
    }

    public String getCarColor(){
        return carColor;
    }
    public String getEngineNumber(){
        return engineNumber;
    }
    public String getRegNumber(){
        return regNumber;
    }

    public String gerCarInfo() {
        return "Reg number: " + regNumber + " Engine: " + engineNumber + " Color: " + carColor + " Mileage: " + mileage;
    }

    public boolean equals(Object o){
        if (this == o) { //Гарантируем рефлексивность
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!getClass().equals(o.getClass())) {
            return false;
        }

        Car car = (Car) o;

        if (!(car.carColor).equals(this.carColor)) return false;
        if (!(car.engineNumber).equals(this.engineNumber)) return false;
        if (!(car.regNumber).equals(this.regNumber)) return false;
        return true;

    }

    public int hashCode(){
        int result = carColor != null ? carColor.hashCode() : 0;
        result = 31 * result + (engineNumber != null ? engineNumber.hashCode() : 0);
        result = 31 * result + (regNumber != null ? regNumber.hashCode() : 0);
        return result;
    }
}
