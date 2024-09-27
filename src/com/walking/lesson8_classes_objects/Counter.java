package com.walking.lesson8_classes_objects;

public class Counter {
    public String name;
    public int counter;

    public Counter(String name, int counter){
        this.name = name;
        this.counter = counter;
    }

    public Counter(String name){
        this.name = name; // counter initialised 0 by default
    }

    public int incrementCounter(){
        return ++counter;
    }

    public int decrementCounter(){
        return --counter;
    }

    public int increaseCounterByValue(int value){
        counter += value;
        return counter;
    }

    public int decrementCounterByUserNumber(int value){
        counter -= value;
        return counter;
    }


}
