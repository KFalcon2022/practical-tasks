package com.walking.lesson16_abstract_class_interface.task3;

public class Main {
    public static void main(String[] args) {

        Soundable animal = new Dog("Rex");
        animal.sound();
        animal = new Cat("Masya");
        animal.sound();
    }


}
interface Soundable{

    void sound();
}

 abstract class Animal implements Soundable {
     protected String sound;
     protected String name;

     Animal(String name) {
         this.name = name;
     }
     public void sound() {
         System.out.println(name + " says " +sound);
     }
 }
class Dog extends Animal {

    Dog(String name){
        super(name);
        sound = "uff";
    }


}
class Cat extends Animal{
    Cat(String name){
        super(name);
        sound = "meow";
    }

}
