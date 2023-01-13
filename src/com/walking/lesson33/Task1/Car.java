package com.walking.lesson33.Task1;

public class Car {
    private final String number;
    private final String owner;
    private final String model;

    public Car(String number, String owner, String model){
        this.number = number;
        this.owner = owner;
        this.model = model;
    }

    @Override
    public String toString(){
        return String.format("%s, %s, %s", number, owner, model);
    }

    public String getNumber(){ return number; }

    public String getOwner(){ return owner; }

    public String getModel(){ return model; }

}
