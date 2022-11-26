package lesson14;


import lesson14.task2Animals.Task2Animal;
import lesson14.task2Animals.Task2Dog;
import lesson14.task2Animals.Task2Cat;
import lesson14.task2Animals.Task2Cow;

/**
 * Используя новые знания, упростите реализацию задачи 2 из предыдущего урока.
 * Допустимо использовать метод sound(), вместо woof(), meow() и moo().
 * Метод sound() допустимо сделать публичным.
 *
 * Использовать отдельное поле для хранения выводимой строки — недопустимо:)
 */

public class Task2Main {
    public static void main(String[] args) {
        Task2Animal[] animals = new Task2Animal[10];
        animals[0] = new Task2Dog("Бим");
        animals[1] = new Task2Cow("Бурёнка");
        animals[2] = new Task2Cow("Каролина");
        animals[3] = new Task2Cat("Мурзик");
        animals[4] = new Task2Dog("Мухтар");
        animals[5] = new Task2Cat("Шерлок");
        animals[6] = new Task2Cat("Пуша");
        animals[7] = new Task2Dog("Лопоух");
        animals[8] = new Task2Cow("Мумушка");
        animals[9] = new Task2Cat("Рыжик");

        makeSound(animals);
    }

    public static void makeSound(Task2Animal[] animals) {
        for (Task2Animal animal : animals) {
            animal.sound();
        }
    }
}
