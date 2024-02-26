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
    private static final Runnable getYieldTask = () -> {
        System.out.println(Thread.currentThread().getName() + " запущен и не спешит.");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " завершен.");
    };
    private static final Runnable getNonYieldTask = () -> {
        System.out.println(Thread.currentThread().getName() + " запущен и спешит.");
        System.out.println(Thread.currentThread().getName() + " завершен.");
    };

    public static void main(String[] args) {
        System.out.println("With yield()\n");
        for (int i = 0; i < 10; i++) {
            new Thread(getYieldTask).start();
        }

        System.out.println("\nWithout yield()\n");
        for (int i = 0; i < 10; i++) {
            new Thread(getNonYieldTask).start();
        }

        System.out.println("\nWith yield() and priority 10\n");
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(getYieldTask);
            if (i == 3 || i == 7) {
                t.setPriority(10);
            }

            t.start();
        }
    }
}