package com.walking.lesson61_synchronized.model;

public class CarIdentificator {
    private String plateNumber;
    private int releaseYear;
    private final int HASHCODE;
    public CarIdentificator(String plateNumber, int releaseYear){
        this.plateNumber = plateNumber;
        this.releaseYear = releaseYear;
        HASHCODE=hashCode();
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    @Override
    public boolean equals(Object obj){
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (!getClass().equals(obj.getClass()))
            return false;
        CarIdentificator car = (CarIdentificator) obj;
        return this.plateNumber.equals(car.plateNumber) && this.releaseYear ==(car.releaseYear);
    }
    @Override
    public int hashCode(){
        if (HASHCODE==0) {
            int result = plateNumber.hashCode();
            result = 31 * result + releaseYear;
            return result;
        }
        else return HASHCODE;
    }
}
