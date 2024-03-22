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
        Counter oddCounter = new Counter("Нечетные числа");
        Counter evenCounter = new Counter("Четные числа");

        calculateCounters(oddCounter, evenCounter);
        printOddAndEvenCounters(oddCounter, evenCounter);
    }

    public static void calculateCounters(Counter oddCounter, Counter evenCounter) {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                evenCounter.incrementCounter();
            } else {
                oddCounter.incrementCounter();
            }
        }
    }

    public static void printOddAndEvenCounters(Counter oddCounter, Counter evenCounter) {
        System.out.println(oddCounter.name + ": " + oddCounter.count);
        System.out.println(evenCounter.name + ": " + evenCounter.count);
    }
}
