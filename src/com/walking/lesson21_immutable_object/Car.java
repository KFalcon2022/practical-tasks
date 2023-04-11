package Lesson21;

public class Car {
    private String owner;
    private CarCharacteristics characteristics;
    public Car(String owner, String carID)
    {
        if (owner.length()<3 || ownerValidation(owner))
        {
            this.owner = owner;
        }
        characteristics = new CarCharacteristics(carID);
    }

    private boolean ownerValidation(String owner)
    {
        String[] parseOwner = owner.split("\\s+");
        if (parseOwner.length < 2) throw new CarCharException("Car owner format NAME LASTNAME, not:", owner);
        return true;
    }
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (this.equals(obj))
            return true;
        if (!this.getClass().equals(obj.getClass()))
            return false;
        Car car = (Car) obj;
        return (this.hashCode() == car.hashCode() && this.owner.equals(car.owner));
    }
    public int hashCode()
    {
        return characteristics.hashCode();
    }

    public String toString()
    {
        return """
                car owner: %s
               """.formatted(owner) + characteristics.toString();
    }
}
