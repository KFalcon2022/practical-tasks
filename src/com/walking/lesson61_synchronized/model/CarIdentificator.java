package com.walking.lesson61_synchronized.model;

public class CarIdentificator {
    private final int hashcode;
    private final int releaseYear;
    private final String plateNumber;

    public CarIdentificator(String plateNumber, int releaseYear) {
        this.plateNumber = plateNumber;
        this.releaseYear = releaseYear;
        hashcode = hashCode();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public String toString() {
        return """
                \n| Plate number: %s | Release year: %s\s""".formatted(plateNumber, releaseYear);
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
        CarIdentificator carID = (CarIdentificator) obj;

        return this.plateNumber.equals(carID.plateNumber) && this.releaseYear == (carID.releaseYear);
    }

    @Override
    public int hashCode() {
        if (hashcode == 0) {
            return 31 * plateNumber.hashCode() + releaseYear;
        }

        return hashcode;
    }
}
