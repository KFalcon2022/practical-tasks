package com.walking.lesson16_abstract_class_interface.task2;

interface Printable{
    
    void print();
   
    static void say(String message){
        System.out.println(message);
    }
}