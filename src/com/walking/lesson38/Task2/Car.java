package com.walking.lesson38.Task2;

public class Car implements Comparable<Car>{
    private final String number;
    private final String owner;
    private final String model;
    private final int year;

    public Car(String number, String owner, String model, int year){
        this.number = number;
        this.owner = owner;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString(){
        return String.format("%s, %s, %s, %d", number, owner, model, year);
    }

    public String getNumber(){ return number; }

    public String getOwner(){ return owner; }

    public String getModel(){ return model; }

    public int getYear(){ return year; }
    public String identifier(){ return "%d/%s".formatted(year, number); }

    @Override
    public int compareTo(Car o) {
        return identifier().compareTo(o.identifier());
    }
}
