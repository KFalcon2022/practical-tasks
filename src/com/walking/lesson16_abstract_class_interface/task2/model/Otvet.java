package com.walking.lesson16_abstract_class_interface.task2.model;

public class Otvet implements Output{
    String string;
    public Otvet(String string){
        this.string=string;
    }
    @Override
    public void print(){
        System.out.println(string + " "+ string);
    }

}
