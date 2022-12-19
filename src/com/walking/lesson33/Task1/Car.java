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

    public Car(String data){
        String[] parts = data.strip().split(":");
        this.number = parts.length > 0 ? parts[0] : "";
        this.owner = parts.length > 1 ? parts[1] : "";
        this.model = parts.length > 2 ? parts[2] : "";
    }

    @Override
    public String toString(){
        return String.format("%s, %s, %s", number, owner, model);
    }

    public String asObject(){
        return String.format("%s:%s:%s", number, owner, model);
    }
}
