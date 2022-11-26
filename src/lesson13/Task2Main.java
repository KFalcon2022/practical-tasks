package lesson13;

import lesson13.task2Animals.Task2Animal;
import lesson13.task2Animals.Task2Dog;
import lesson13.task2Animals.Task2Cat;
import lesson13.task2Animals.Task2Cow;

/**
 * Реализуйте класс Animal. Реализуйте его наследников: Dog, Cat, Cow.
 * Каждый из наследников должен содержать свой метод: woof(), meow() и moo() соответственно.
 * Остальные поля и методы суперкласса и наследников реализовать по своему усмотрению, если они необходимы.
 *
 * Каждый из методов должен выводить в консоль соответствующую ему строку: "woof ", "meow " или "moo".
 *
 * В main() создать и наполнить в произвольном порядке объектами разных классов-наследников массив типа Animal.
 * Реализовать метод, принимающий массив Animal и вызывающий метод, характерный для конкретного животного.
 *
 * Использовать при решении instanceof, getClass() или другие неизвестные нам механики – недопустимо.
 *
 * Дополнительное условие (необязательно): решить задачу, при условии, что woof(), meow() и moo()
 * внутри себя выполняют только вызов protected-метода sound(), который определен в Animal.
 */

public class Task2Main {
    public static void main(String[] args) {
        Task2Animal[] animals = new Task2Animal[10];
        animals[0] = new Task2Dog("Бим", "dog");
        animals[1] = new Task2Cow("Бурёнка", "cow");
        animals[2] = new Task2Cow("Каролина", "cow");
        animals[3] = new Task2Cat("Мурзик", "cat");
        animals[4] = new Task2Dog("Мухтар", "dog");
        animals[5] = new Task2Cat("Шерлок", "cat");
        animals[6] = new Task2Cat("Пуша", "cat");
        animals[7] = new Task2Dog("Лопоух", "dog");
        animals[8] = new Task2Cow("Мумушка", "cow");
        animals[9] = new Task2Cat("Рыжик", "cat");

        makeSound(animals);
    }

    public static void makeSound(Task2Animal[] animals) {
        for (Task2Animal animal : animals) {
            if (animal.type == "dog") {
                Task2Dog castedDog = (Task2Dog) animal;
                castedDog.woof();
            } else if (animal.type == "cat") {
                Task2Cat castedCat = (Task2Cat) animal;
                castedCat.meow();
            } else if (animal.type == "cow") {
                Task2Cow castedCow = (Task2Cow) animal;
                castedCow.moo();
            }
        }
    }
}
