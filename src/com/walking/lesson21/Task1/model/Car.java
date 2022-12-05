package com.walking.lesson21.Task1.model;

public class Car{
    
    private final CarModel model;
    private String number;
    private Region region;
    private Person owner;
    
    public Car(CarModel model, String number, Region region, String owner) {
        this.model = model;
        setNumber(number);
        setRegion(region);
        setOwner(owner);
    }
    
    public void setNumber(String number) {
        this.number = number.toUpperCase();
    }
 
    public void setRegion(Region region) {
        this.region = region;
    }

    public void setOwner(String owner) { this.owner = new Person(owner); }

    public boolean isOwner(String searchOwner) { return this.owner.toString().toLowerCase().contains(searchOwner.toLowerCase()); }

    public boolean isModel(String searchModel) { return this.model.toString().toLowerCase().contains(searchModel.toLowerCase()); }

    @Override
    public String toString() {
        return String.format("%s. Owner: %s, Number: %s, Region: %d %s", model.getName(), owner, number, region.getValue(), region.getTitle());
    }

    public int hashCode() { return (this.region + this.number).hashCode(); }

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