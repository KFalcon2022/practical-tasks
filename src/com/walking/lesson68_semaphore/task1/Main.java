package com.walking.lesson68_semaphore.task1;

import com.walking.lesson68_semaphore.task1.model.Philosopher;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
 * Вилки лежат на столе между каждой парой ближайших философов.
 * Каждый философ может либо есть, либо размышлять.
 * Приём пищи не ограничен количеством оставшихся спагетти — подразумевается бесконечный запас.
 * Тем не менее, философ может есть только тогда, когда держит две вилки — взятую справа и слева.
 * Каждый философ может взять ближайшую вилку (если она доступна) или положить —
 * если он уже держит её. Взятие каждой вилки и возвращение её на стол
 * являются раздельными действиями, которые должны выполняться одно за другим.
 * Чтобы наесться, каждый философ должен поесть трижды.
 * Необходимо накормить философов как можно быстрее – ситуация,
 * когда они будут есть строго по одному – недопустима.
 * <p>
 * Решите задачу об обедающих философах, используя посредника –
 * механизм, определяющий, кто из философов может взять вилку.
 * <p>
 * <a href="https://pastebin.com/PHxMKpwq">Подсказка</a>
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Проверка решения на 10_000 запусках
        for (int i = 0; i < 10000; i++) {
            System.out.printf("%dth start\n", i);
            test();
            System.out.printf("%dth finish\n\n\n", i);
        }
    }

    private static void test() throws InterruptedException {
//        В данном решении рассматриваем вариант на тему арбитра.
//        Позволяем получать доступ к ресурсам лишь четверым философам. Таким образом,
//        если четверо уже пытаются взять вилки - пятый будет ждать, пока хотя бы один из четверых не закончит
        var eatingPhilosopherCounter = new Semaphore(4);

        var fork1 = new ReentrantLock();
        var fork2 = new ReentrantLock();
        var fork3 = new ReentrantLock();
        var fork4 = new ReentrantLock();
        var fork5 = new ReentrantLock();

        var thread1 = new Thread(getPhilosopherLogic(new Philosopher("1", fork1, fork2), eatingPhilosopherCounter));
        var thread2 = new Thread(getPhilosopherLogic(new Philosopher("2", fork2, fork3), eatingPhilosopherCounter));
        var thread3 = new Thread(getPhilosopherLogic(new Philosopher("3", fork3, fork4), eatingPhilosopherCounter));
        var thread4 = new Thread(getPhilosopherLogic(new Philosopher("4", fork4, fork5), eatingPhilosopherCounter));
        var thread5 = new Thread(getPhilosopherLogic(new Philosopher("5", fork5, fork1), eatingPhilosopherCounter));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
    }

    private static Runnable getPhilosopherLogic(Philosopher philosopher, Semaphore eatingPhilosopherCounter) {
        return () -> {
            while (philosopher.getEatenCounter() < 3) {
//                try-finally можно и поменьше. Но так нагляднее порядок вызовов
                try {
                    eatingPhilosopherCounter.acquireUninterruptibly();
                    try {
                        philosopher.getRightFork().lock();
                        try {
                            philosopher.getLeftFork().lock();

                            var eatenCounter = philosopher.getEatenCounter();
                            philosopher.setEatenCounter(++eatenCounter);

                            System.out.printf("Philosopher %s has eaten %d times\n",
                                    philosopher.getName(), philosopher.getEatenCounter());
                        } finally {
                            philosopher.getLeftFork().unlock();
                        }
                    } finally {
                        philosopher.getRightFork().unlock();
                    }
                } finally {
                    eatingPhilosopherCounter.release();
                }
            }
        };
    }
}