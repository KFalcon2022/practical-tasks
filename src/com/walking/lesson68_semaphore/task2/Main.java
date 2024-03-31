package com.walking.lesson68_semaphore.task2;

import com.walking.lesson68_semaphore.task2.model.Philosopher;
import com.walking.lesson68_semaphore.task2.service.PhilosopherLunchCounter;

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
    public static void main(String[] args) {
        Philosopher philosopher1 = new Philosopher(1);
        Philosopher philosopher2 = new Philosopher(2);
        Philosopher philosopher3 = new Philosopher(3);
        Philosopher philosopher4 = new Philosopher(4);
        Philosopher philosopher5 = new Philosopher(5, philosopher4, philosopher1);

        philosopher1.setLeftPhilosopher(philosopher5);
        philosopher1.setRightPhilosopher(philosopher2);
        philosopher2.setLeftPhilosopher(philosopher1);
        philosopher2.setRightPhilosopher(philosopher3);
        philosopher3.setLeftPhilosopher(philosopher2);
        philosopher3.setRightPhilosopher(philosopher4);
        philosopher4.setLeftPhilosopher(philosopher3);
        philosopher4.setRightPhilosopher(philosopher5);

        new Thread(new PhilosopherLunchCounter(philosopher1)).start();
        new Thread(new PhilosopherLunchCounter(philosopher2)).start();
        new Thread(new PhilosopherLunchCounter(philosopher3)).start();
        new Thread(new PhilosopherLunchCounter(philosopher4)).start();
        new Thread(new PhilosopherLunchCounter(philosopher5)).start();
    }
}