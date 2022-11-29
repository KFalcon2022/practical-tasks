//package com.walking.lesson16_abstract_class_interface.task3;

public class Cow extends Animal{

    public Cow(String name) {
        super(name, 0);
    }
    
    public Cow(String name, int age) {
        super(name, age);
    }
    
    private String moo(){
        return "moo";
    }
    
    public String talk(){
        return moo();
    }
}