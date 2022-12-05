package com.walking.lesson16_abstract_class_interface.task3;

public class Cat extends Animal{

    public Cat(String name) {
        super(name, 0);
    }
    
    public Cat(String name, int age) {
        super(name, age);
    }
    
    private String meow(){
        return "meow";
    }
    
    public String talk(){
        return meow();
    }
}