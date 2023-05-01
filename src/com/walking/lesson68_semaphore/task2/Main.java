package com.walking.lesson68_semaphore.task2;

import com.walking.lesson68_semaphore.task2.model.Philosopher;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

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
 * Решите задачу об обедающих философах, не вводя блокировок, связанных с вилками.
 * <p>
 * <a href="https://pastebin.com/QUxS59Qc">Подсказка</a>
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
//        В данном решении рассматриваем сценарий, когда философ проверяет состояние своих соседей.
//        Он может взять вилки только если ни один из соседей не ест в данный момент => обе вилки свободны
        var fork1 = new AtomicBoolean();
        var fork2 = new AtomicBoolean();
        var fork3 = new AtomicBoolean();
        var fork4 = new AtomicBoolean();
        var fork5 = new AtomicBoolean();

        var philosopherByNumber = Map.of(
                1, new Philosopher(1, fork1, fork2),
                2, new Philosopher(2, fork2, fork3),
                3, new Philosopher(3, fork3, fork4),
                4, new Philosopher(4, fork4, fork5),
                5, new Philosopher(5, fork5, fork1));

        var thread1 = new Thread(getPhilosopherLogic(philosopherByNumber.get(1), philosopherByNumber));
        var thread2 = new Thread(getPhilosopherLogic(philosopherByNumber.get(2), philosopherByNumber));
        var thread3 = new Thread(getPhilosopherLogic(philosopherByNumber.get(3), philosopherByNumber));
        var thread4 = new Thread(getPhilosopherLogic(philosopherByNumber.get(4), philosopherByNumber));
        var thread5 = new Thread(getPhilosopherLogic(philosopherByNumber.get(5), philosopherByNumber));

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

    private static Runnable getPhilosopherLogic(Philosopher philosopher, Map<Integer, Philosopher> philosopherByNumber) {
        return () -> {
            var neighbourNumber1 = philosopher.getNumber() == 1
                    ? philosopherByNumber.size()
                    : philosopher.getNumber() - 1;
            var neighbour1 = philosopherByNumber.get(neighbourNumber1);

            var neighbourNumber2 = philosopher.getNumber() == philosopherByNumber.size()
                    ? 1
                    : philosopher.getNumber() + 1;
            var neighbour2 = philosopherByNumber.get(neighbourNumber2);

            while (philosopher.getEatenCounter() < 3) {
                synchronized (philosopherByNumber) {
                    if (neighbour1.getEating().get() || neighbour2.getEating().get()) {
                        continue;
                    }

                    philosopher.getEating().set(true);
                }

//                В этом решении нет необходимости в флаге занятости вилок.
//                Здесь - лишь как демонстрация корректности концепции
                if (philosopher.getRightForkOccupied().get() || philosopher.getLeftForkOccupied().get()) {
                    throw new RuntimeException();
                }

                philosopher.getRightForkOccupied().set(true);
                philosopher.getLeftForkOccupied().set(true);

                var eatenCounter = philosopher.getEatenCounter();
                philosopher.setEatenCounter(++eatenCounter);

                System.out.printf("Philosopher %d has eaten %d times\n",
                        philosopher.getNumber(), philosopher.getEatenCounter());

                philosopher.getRightForkOccupied().set(false);
                philosopher.getLeftForkOccupied().set(false);
                philosopher.getEating().set(false);
            }
        };
    }
}