package com.walking.lesson68_semaphore.task1;

import com.walking.lesson68_semaphore.task1.model.Philosopher;
import com.walking.lesson68_semaphore.task1.service.PhilosopherLunchCounter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
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
    public static void main(String[] args) {
        Semaphore forkSemaphore = new Semaphore(4);
        Lock fork1 = new ReentrantLock();
        Lock fork2 = new ReentrantLock();
        Lock fork3 = new ReentrantLock();
        Lock fork4 = new ReentrantLock();
        Lock fork5 = new ReentrantLock();

        new Thread(new PhilosopherLunchCounter(new Philosopher(1, fork1, fork2), forkSemaphore)).start();
        new Thread(new PhilosopherLunchCounter(new Philosopher(2, fork2, fork3), forkSemaphore)).start();
        new Thread(new PhilosopherLunchCounter(new Philosopher(3, fork3, fork4), forkSemaphore)).start();
        new Thread(new PhilosopherLunchCounter(new Philosopher(4, fork4, fork5), forkSemaphore)).start();
        new Thread(new PhilosopherLunchCounter(new Philosopher(5, fork5, fork1), forkSemaphore)).start();
    }
}