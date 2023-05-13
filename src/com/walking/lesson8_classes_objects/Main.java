package com.walking.lesson8_classes_objects;

/**
 * Реализовать класс-счетчик.
 * Полями класса должны выступать название счетчика и, непосредственно, целочисленный счетчик.
 * <p>
 * Реализовать для созданного класса конструктор с двумя параметрами,
 * с одним (значение счетчика в таком случае инициализировать как 0),
 * методы увеличения и уменьшения счетчиков на 1 и на заданное пользователем целом значение.
 * Методы должны возвращать актуальное значение счетчика.
 * <p>
 * Используя созданный класс,
 * посчитать количество четных и количество нечетных чисел в ряду от 1 до 100.
 * Конечные показатели счетчиков вывести в консоль.
 */
public class Main {
    public static void main(String[] args) {
        Counter evenNumbers = new Counter("Even numbers");
        Counter oddNumbers = new Counter("Odd numbers");

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                evenNumbers.incrementCounter();
            } else {
                oddNumbers.incrementCounter();
            }
        }

        printCounter(evenNumbers.name, evenNumbers.counter);
        printCounter(oddNumbers.name, oddNumbers.counter);

    }

    public static void printCounter(String name, int counter) {
        System.out.println(name + ": " + counter);
    }
}
