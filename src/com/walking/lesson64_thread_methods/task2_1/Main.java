package com.walking.lesson64_thread_methods.task2_1;

import com.walking.lesson64_thread_methods.model.RandomGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


/**
 * Напишите программу, заполняющую двумерный массив большого размера
 * (подберите на свой вкус, ограничения могут зависеть от заданного размера хипа в JVM)
 * случайными числами. Параллельно должен работать поток,
 * каждые 100 миллисекунд пишущий в консоль текущее время.
 * <p>
 * Программа должна завершиться, как только массив будет заполнен.
 * Предоставьте три различных решения данной программы. (Первое)
 */
public class Main {

    public static void main(String[] args) {
        RandomGenerator randomGenerator = new RandomGenerator(1, 99999);
        int[][] nums = new int[10000][10000];

        Thread t = new Thread(runnable());
        t.setDaemon(true);
        t.start();

        System.out.println("Заполняю массив!");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = randomGenerator.generate();
            }
        }
        System.out.println("Массив заполнен!");
    }

    private static Runnable runnable() {
        return () -> {
            try {
                LocalDateTime localDate;
                while (true) {
                    localDate = LocalDateTime.now();
                    System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        };
    }
}