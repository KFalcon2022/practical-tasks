package com.walking.lesson25_nested_classes.task2.anonymous_class;


/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
     Animal[] animals = new Animal[10];
    initAnimalsArray(animals);
    animalSound(animals);
}

    private static void initAnimalsArray(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (i % 2 == 0) {
                animals[i] = new Animal() {
                    @Override
                    public void sound() {
                        System.out.println("meow");
                    }
                };
            } else if (i % 3 == 0) {
                animals[i] = new Animal() {
                    @Override
                    public void sound() {
                        System.out.println("woof");
                    }
                };
            } else {
                animals[i] = new Animal() {
                    @Override
                    public void sound() {
                        System.out.println("moo");
                    }
                };
            }
        }
    }

    private static void animalSound(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
