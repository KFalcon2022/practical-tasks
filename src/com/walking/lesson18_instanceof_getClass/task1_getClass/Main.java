package com.walking.lesson18.getClass;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя getClass().
 */
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
        switch (animal.getClassName()) {
            case Cat.CAT_CLASS_NAME:
                if(animal.getClass().equals(Cat.class)) { //проверка на тип объекта, является ли тип переменной Cat и Animal одинаковым
                    ((Cat) animal).meow();
                }
                break;
            case Dog.DOG_CLASS_NAME:
                if(animal.getClass().equals(Cat.class)){ //проверка на тип объекта, является ли тип переменной Dog и Animal одинаковым
                   ((Dog)animal).woof();
                }
                break;
            case Cow.COW_CLASS_NAME:
                if(animal.getClass().equals(Cat.class)){ //проверка на тип объекта, является ли тип переменной Cow и Animal одинаковым
                    ((Cow)animal).moo();
                }
                break;
            default: //На случай, если был создан объект Animal, а не наследника.
                // Или если наследник неизвестен
                System.out.println("Unknown animal!");
        }
    }
}
