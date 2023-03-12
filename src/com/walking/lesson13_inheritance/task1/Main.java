package com.walking.lesson13_inheritance.task1;

/**
 * Реализовать класс Animal, содержащий protected-конструктор без параметров,
 * который выводит в консоль сообщение «I’m an animal».
 * <p>
 * Реализовать для Animal классы-наследники Dog и Cat.
 * Реализовать для каждого из них приватный конструктор без параметров,
 * который выводит в консоль сообщение «I’m a dog» («I’m a cat»).
 * Также реализовать публичный конструктор, принимающий строковый параметр color.
 * Он должен вызывать конструктор без параметров,
 * а также выводить в консоль сообщение «I’m a <color> dog» («I’m a <color> cat»),
 * где <color> – значение параметра конструктора color.
 * <p>
 * Создайте в main() экземпляр Dog и экземпляр Cat.
 * Обратите внимание на консоль.
 * Такой ли порядок сообщений вы ожидали увидеть?
 */
package com.walking.lesson14;

import com.walking.lesson14.Dog;
import com.walking.lesson14.Cat;

public class Main {
    public static void main(String[] args) {
       new Dog("white");
       new Cat("black");
    }
}
