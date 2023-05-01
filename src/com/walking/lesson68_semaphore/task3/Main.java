package com.walking.lesson68_semaphore.task3;

import com.walking.lesson68_semaphore.task3.model.Philosopher;

import java.util.Map;
import java.util.Set;
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
 * Решите задачу об обдающих философах, основываясь порядковых номерах вилок.
 * <p>
 * <a href="https://pastebin.com/q4yQPjSe">Подсказка</a>
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
//        В данном решении рассматриваем сценарий, когда вилки пронумерованы по порядку.
//        Философы сначала берут вилку с меньшим номером, потом с большим.
//        Освобождают же наоборот - сначала с большим номером, потом с меньшим. Семафор в этом решении не нужен
        var forkByNumber = Map.of(
                1, new ReentrantLock(),
                2, new ReentrantLock(),
                3, new ReentrantLock(),
                4, new ReentrantLock(),
                5, new ReentrantLock());

        var thread1 = new Thread(getPhilosopherLogic(new Philosopher("1", Set.of(1, 2)), forkByNumber));
        var thread2 = new Thread(getPhilosopherLogic(new Philosopher("2", Set.of(2, 3)), forkByNumber));
        var thread3 = new Thread(getPhilosopherLogic(new Philosopher("3", Set.of(3, 4)), forkByNumber));
        var thread4 = new Thread(getPhilosopherLogic(new Philosopher("4", Set.of(4, 5)), forkByNumber));
        var thread5 = new Thread(getPhilosopherLogic(new Philosopher("5", Set.of(5, 1)), forkByNumber));

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

    private static Runnable getPhilosopherLogic(Philosopher philosopher, Map<Integer, ReentrantLock> forkByNumber) {
        return () -> {
            var minForkNumber = philosopher.getForkNumbers().first();
            var maxForkNumber = philosopher.getForkNumbers().last();

            while (philosopher.getEatenCounter() < 3) {
                try {
                    forkByNumber.get(minForkNumber).lock();
                    try {
                        forkByNumber.get(maxForkNumber).lock();

                        var eatenCounter = philosopher.getEatenCounter();
                        philosopher.setEatenCounter(++eatenCounter);

                        System.out.printf("Philosopher %s has eaten %d times\n",
                                philosopher.getName(), philosopher.getEatenCounter());
                    } finally {
                        forkByNumber.get(maxForkNumber).unlock();
                    }
                } finally {
                    forkByNumber.get(minForkNumber).unlock();
                }
            }
        };
    }
}