package com.walking.lesson25_nested_classes.task2.nested_class.model;

public class Animal {
    private Pet pt;

    public Animal(Pet pet){
        this.pt=pet;
    }

    public void sound(){
        switch (pt) {
            case Pet.Cat:
                Cat cat=new Cat();
                cat.sound();       
                break;
            case Pet.Dog:
                Dog dog=new Dog();
                dog.sound();
                break;
            case Pet.Cow:
                Cow cow=new Cow();
                cow.sound();
                break;        
        }
    }
    
    public enum Pet{
        Cat,Dog,Cow
    }

    class Cat{
        public void sound(){
            System.out.println("Meow");
        }
    }
    class Dog{
        public void sound(){
            System.out.println("Woof");
        }
    }
    class Cow{
        public void sound(){
            System.out.println("Moo");
        }
    }
}

