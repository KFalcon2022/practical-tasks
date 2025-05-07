package com.walking.lesson18.getClass;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow()};

        soundAll(animals);
    }
    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal);
        }
    }

    //    Используя поле класса Animal, определяем, какой настоящий класс обрабатываемого объекта
   private static void sound(Animal animal) {
           if(Cat.class.equals(animal.getClass())) { //проверка на тип объекта, является ли тип переменной Cat и Animal одинаковым
                  ((Cat) animal).meow();
           }
           else {
               if(Dog.class.equals(animal.getClass())){ //проверка на тип объекта, является ли тип переменной Dog и Animal одинаковым
                   ((Dog)animal).woof();
                }
           else {
               if (Cow.class.equals(animal.getClass())) { //проверка на тип объекта, является ли тип переменной Cow и Animal одинаковым
                   ((Cow) animal).moo();
               }
           else {
                   //На случай, если был создан объект Animal, а не наследника.
                   // Или если наследник неизвестен
                   System.out.println("Unknown animal!");
                }
           }
        }
    }
}
