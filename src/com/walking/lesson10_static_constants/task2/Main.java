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
        Counter evenCounter = new Counter("Четные числа");
        Counter oddCounter = new Counter("Нечетные числа");

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                evenCounter.increment();
            } else {
                oddCounter.increment();
            }
        }

        printCounterValue(evenCounter);
        printCounterValue(oddCounter);
    }

    static void printCounterValue(Counter counter) {
        System.out.printf("%s: %d\n", counter.name, counter.counter);
    }
}
