package com.walking.lesson18;

/**
 * Реализовать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson13_inheritance/task2">...</a>
 * используя instanceof.
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
                if (animal instanceof Cat catty){ //проверяем, может ли животное стать котом с помощью оператора instanceof
                    catty.meow(); // если может, то тогда кот мяукает
                }
                break;
            case Dog.DOG_CLASS_NAME:
                if (animal instanceof Dog doggo){ //проверяем, может ли животное стать собакой с помощью оператора instanceof
                    doggo.woof(); // если может, то тогда собака гавкает
                }
                break;
            case Cow.COW_CLASS_NAME:
                if (animal instanceof Cow cowwo){ //проверяем, может ли животное стать коровой с помощью оператора instanceof
                    cowwo.moo(); // если может, то тогда корова мычит
                }
                break;
            default: //На случай, если был создан объект Animal, а не наследника.
                // Или если наследник неизвестен
                System.out.println("Unknown animal!");
        }
    }
}
