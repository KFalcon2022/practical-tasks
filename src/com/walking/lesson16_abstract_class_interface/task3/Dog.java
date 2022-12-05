package com.walking.lesson16_abstract_class_interface.task3;

public class Dog extends Animal{

    public Dog(String name) {
        super(name, 0);
    }
    
    public Dog(String name, int age) {
        super(name, age);
    }
    
    private String woof(){
        return "woof";
    }
    
    public String talk(){
        return woof();
    }
}