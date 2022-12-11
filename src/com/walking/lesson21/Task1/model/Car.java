package com.walking.lesson21.Task1.model;

public class Car{
    
    private final CarModel model;
    private CarNumber number;
    private Person owner;
    
    public Car(CarModel model, String number, Region region, String owner) {
        this.model = model;
        this.number = new CarNumber(region, number);
        this.owner = new Person(owner);
    }
    
    @Override
    public String toString() {
        return String.format("%s. Owner: %s, %s", model.getName(), owner, number);
    }

    public Person getOwner() {
        return owner;
    }

    public CarModel getModel() {
        return model;
    }

    public CarNumber getNumber() {return number;}

    // number и owner не финальные
    // здесь могли бы быть методы setOwner, setNumber
}