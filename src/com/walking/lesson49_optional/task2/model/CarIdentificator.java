package com.walking.lesson49_optional.task2.model;

//В предыдущих задачах реализована сложная и запутанная версия с CarSpecification
// Из-за этого проще и быстрее создать класс по аналогии с автором курса

public class CarIdentificator implements Comparable<CarIdentificator>{
    private final String PLATE_NUMBER;
    private final int RELEASE_YEAR;
    private final int HASH_CODE;

    public CarIdentificator(String plateNumber, int releaseYear) {
        this.PLATE_NUMBER = plateNumber;
        this.RELEASE_YEAR = releaseYear;
        this.HASH_CODE=hashCode();
    }

    @Override
    public int compareTo(CarIdentificator o) {
        int resultNumber = PLATE_NUMBER.compareTo(o.PLATE_NUMBER);
        if (resultNumber==0){
            return RELEASE_YEAR-o.RELEASE_YEAR;
        }
        return resultNumber;
    }
    public String getPlateNumber() {
        return PLATE_NUMBER;
    }

    public int getReleaseYear() {
        return RELEASE_YEAR;
    }

    @Override
    public int hashCode() {
        if (HASH_CODE==0){
            int result = PLATE_NUMBER.hashCode();
            result+=31*RELEASE_YEAR;
            return result;
        }
        return HASH_CODE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (!getClass().equals(obj.getClass()))
            return false;
        CarIdentificator carId = (CarIdentificator) obj;
        if (this.PLATE_NUMBER.equals(carId.PLATE_NUMBER)&&this.RELEASE_YEAR==carId.RELEASE_YEAR)
            return true;

        return false;
    }
}
