package lesson13;

import lesson13.task1Animals.Task1Cat;
import lesson13.task1Animals.Task1Dog;

/**
 * Реализовать класс Animal, содержащий protected-конструктор без параметров,
 * который выводит в консоль сообщение «I’m an animal».
 *
 * Реализовать для Animal классы-наследники Dog и Cat.
 * Реализовать для каждого из них приватный конструктор без параметров,
 * который выводит в консоль сообщение «I’m a dog» («I’m a cat»).
 * Также реализовать публичный конструктор, принимающий строковый параметр color.
 * Он должен вызывать конструктор без параметров, а также выводить в консоль сообщение
 * «I’m a <color> dog» («I’m a <color> cat»), где <color> – значение параметра конструктора color.
 *
 * Создайте в main() экземпляр Dog и экземпляр Cat. Обратите внимание на консоль.
 * Такой ли порядок сообщений вы ожидали увидеть?
 */

public class Task1Main {
    public static void main(String[] args) {
        Task1Dog dog = new Task1Dog("grey");
        Task1Cat cat = new Task1Cat("white");
    }
}
