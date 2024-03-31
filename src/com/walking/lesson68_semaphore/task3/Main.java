package com.walking.lesson68_semaphore.task3;

import com.walking.lesson68_semaphore.task3.model.Philosopher;
import com.walking.lesson68_semaphore.task3.service.PhilosopherLunchCounter;

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
    public static void main(String[] args) {
        Map<Integer, ReentrantLock> forks = Map.of(
                1, new ReentrantLock(),
                2, new ReentrantLock(),
                3, new ReentrantLock(),
                4, new ReentrantLock(),
                5, new ReentrantLock());

        new Thread(new PhilosopherLunchCounter(new Philosopher(1, Set.of(1, 2)), forks)).start();
        new Thread(new PhilosopherLunchCounter(new Philosopher(2, Set.of(2, 3)), forks)).start();
        new Thread(new PhilosopherLunchCounter(new Philosopher(3, Set.of(3, 4)), forks)).start();
        new Thread(new PhilosopherLunchCounter(new Philosopher(4, Set.of(4, 5)), forks)).start();
        new Thread(new PhilosopherLunchCounter(new Philosopher(5, Set.of(5, 1)), forks)).start();
    }
}