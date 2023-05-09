package com.walking.lesson18.instance_of;

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
        if (animal instanceof Cat cat) { //проверяем, может ли животное стать котом с помощью оператора instanceof
            cat.meow(); // если может, то тогда кот мяукает
        }
        else {
            if (animal instanceof Dog dog) { //проверяем, может ли животное стать собакой с помощью оператора instanceof
                dog.woof(); // если может, то тогда собака гавкает
            }
        else {
            if (animal instanceof Cow cow) { //проверяем, может ли животное стать коровой с помощью оператора instanceof
                cow.moo(); // если может, то тогда корова мычит
            }
        else {  //На случай, если был создан объект Animal, а не наследника.
                // Или если наследник неизвестен
                System.out.println("Unknown animal!");
            }
            }
        }
    }
}
