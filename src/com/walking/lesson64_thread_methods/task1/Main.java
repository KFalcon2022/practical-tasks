package com.walking.lesson64_thread_methods.task1;

/**
 * Напишите программу из 10 последовательно запускающихся потоков.
 * Каждый из этих потоков должен выводить в консоль сообщение вида
 * «%Имя потока% запущен и не спешит», вызывать yield(),
 * а после выводить сообщение «%Имя потока% завершен».
 * <p>
 * Обратите внимание на порядок вывода. Как он изменится, если убрать yield()?
 * Как изменится ситуация, если паре потоков выставить приоритет 10?
 */
public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            var threadName = Thread.currentThread().getName();

            System.out.printf("%s запущен и не спешит\n", threadName);
            Thread.yield();
            System.out.printf("%s завершен\n", threadName);
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}