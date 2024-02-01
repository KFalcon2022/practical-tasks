package com.walking.lesson61_synchronized.model;

public class Car {
        private final CarIdentificator CAR_IDENTIFICATOR;

    private String color;
        private final int HASCODE;
        public Car(CarIdentificator carIdentificator, String color) {
            this.CAR_IDENTIFICATOR=carIdentificator;
            this.color =color;
            HASCODE=hashCode();
        }
    public void setColor(String color) {
        this.color = color;
    }

        @Override
        public String toString() {
            return """
                \nPlate number: %s | Release year: %d | Color: %s""".formatted(
                    CAR_IDENTIFICATOR.getPlateNumber(),
                    CAR_IDENTIFICATOR.getReleaseYear(),
                    color);
        }

        public CarIdentificator getCarIdentificator() {
            return CAR_IDENTIFICATOR;
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
        return this.CAR_IDENTIFICATOR.equals(car.CAR_IDENTIFICATOR);
    }
    @Override
    public int hashCode(){
        if (HASCODE==0) {
            return 31 * CAR_IDENTIFICATOR.hashCode();
        }
        else return HASCODE;
    }
}
