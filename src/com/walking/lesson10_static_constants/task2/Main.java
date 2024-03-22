package com.walking.lesson10_static_constants.task2;


/**
 * Для задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/lesson8_classes_objects">...</a>
 * реализуйте неизменность поля названия у класса Counter.
 * Ведь очень странно, если мы можем менять название счетчика по ходу выполнения программы,
 * не так ли?
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
