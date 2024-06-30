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
        Thread t1 = new Thread(runnable());
        Thread t2 = new Thread(runnable());
        Thread t3 = new Thread(runnable());
        Thread t4 = new Thread(runnable());
        Thread t5 = new Thread(runnable());
        Thread t6 = new Thread(runnable());
        Thread t7 = new Thread(runnable());
        Thread t8 = new Thread(runnable());
        Thread t9 = new Thread(runnable());
        Thread t10 = new Thread(runnable());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.setPriority(10);
        t5.start();
        t6.start();
        t7.setPriority(10);
        t7.start();
        t8.start();
        t9.start();
        t10.start();

    }

    private static Runnable runnable() {
        return () -> {
            System.out.printf("%s запущен и не спешит.\n", Thread.currentThread().getName());
            Thread.yield();
            System.out.printf("%s завершен.\n", Thread.currentThread().getName());
        };
    }
}