package com.walking.lesson21.Task1.model;

public class Car{
    
    private final CarModel model;
    private String number;
    private Region region;
    private Person owner;
    
    public Car(CarModel model, String number, Region region, String owner) {
        this.model = model;
        this.number = number.toUpperCase();
        this.region = region;
        this.owner = new Person(owner);
    }
    
    @Override
    public String toString() {
        return String.format("%s. Owner: %s, Number: %s, Region: %d %s",
                model.getName(), owner, number, region.getValue(), region.getTitle());
    }

    public Person getOwner() {
        return owner;
    }

    public CarModel getModel() {
        return model;
    }

    public int hashCode() {
        return (this.region + " " + this.number).hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() == String.class) {
            return this.hashCode() == ((String)o).toUpperCase().hashCode();
        }
        return false;
    } 
}