package com.walking.lesson25_nested_classes.task2.static_class.model;

public class Animal {
    private Pet pt;

    public Animal(Pet pet){
        this.pt=pet;
    }

    public void sound(){
        switch (pt) {
            case Pet.Cat:
                Cat.sound();       
                break;
            case Pet.Dog:
                Dog.sound();
                break;
            case Pet.Cow:
                Cow.sound();
                break;        
        }
    }
    
    public enum Pet{
        Cat,Dog,Cow
    }

    static class Cat{
        static public void sound(){
            System.out.println("Meow");
        }
    }
    static class Dog{
        static public void sound(){
            System.out.println("Woof");
        }
    }
    static class Cow{
        static public void sound(){
            System.out.println("Moo");
        }
    }
}

