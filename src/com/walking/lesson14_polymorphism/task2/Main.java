package com.walking.lesson14_polymorphism.task2;

/**
 * Используя новые знания, упростите реализацию задачи 2 из предыдущего урока:
 * <a href="https://telegra.ph/Nasledovanie-Klyuchevoe-slovo-extends-i-ispolzovanie-protected-Klyuchevoe-slovo-super-Privedenie-ssylochnyh-tipov-11-23">...</a>
 * Допустимо использовать метод sound() вместо woof(), meow() и moo().
 * Метод sound() допустимо сделать публичным.
 * <p>
 * Использовать отдельное поле для хранения выводимой строки — недопустимо:)
 */
public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[]{new Cow(), new Cat(), new Dog()};
        getSound(animals);
    }

    private static void getSound(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
