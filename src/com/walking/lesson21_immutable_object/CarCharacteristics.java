package Lesson21;

public final class CarCharacteristics {
    private final String carID;

    private int hash;
    private int rawNum;
    public CarCharacteristics(String carID)
    {
        if (carID.length() < 4 || carID == null)
            throw new CarCharException("Wrong car number:", carID);
        this.carID = carID;
        getHashValues(carID.toUpperCase());
    }

    private void getHashValues(String carID)
    {
        String carRawValues = null;
        carRawValues = carID.replaceAll("[A-Z]","");
        if (carRawValues.trim().length() < 3)
            throw new CarCharException("Wrong car raw numbers in car ID number row numbers is:", carRawValues.trim());
        rawNum = Integer.parseInt(carRawValues);
    }
    public int hashCode()
    {
        if (this.hash == 0)
        {
            hash = carID.hashCode();
            hash += rawNum*31;
        }
        return hash;
    }
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (this.equals(obj))
            return true;
        if (!this.getClass().equals(obj.getClass()))
            return false;
        CarCharacteristics characteristics = (CarCharacteristics) obj;
        return  (hash == characteristics.hash && carID.equals(characteristics.carID));
    }
    public String toString()
    {
        return """
                carID: %s
                car raw num: %d
                car hash: %d
               """.formatted(carID, rawNum, this.hashCode());
    }
}
