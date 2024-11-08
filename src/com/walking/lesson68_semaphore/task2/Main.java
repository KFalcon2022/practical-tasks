package com.walking.lesson68_semaphore.task2;

import java.util.ArrayList;

import com.walking.lesson68_semaphore.task2.model.Fork;
import com.walking.lesson68_semaphore.task2.model.Philosopher;

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
        ArrayList<Fork> forks=new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            forks.add(new Fork(i));
        }
        ArrayList<Philosopher> philosophers=new ArrayList<>(5);
        philosophers.add(new Philosopher("Sokrat", forks.get(0), forks.get(4)));
        philosophers.add(new Philosopher("Kant", forks.get(1), forks.get(0)));
        philosophers.add(new Philosopher("Izop", forks.get(2), forks.get(1)));
        philosophers.add(new Philosopher("Lokk", forks.get(3), forks.get(2)));
        philosophers.add(new Philosopher("Platon", forks.get(4), forks.get(3)));
        philosophers.get(0).setLeftPhilosopher(philosophers.get(1).getSemaphore());
        philosophers.get(0).setRightPhilosopher(philosophers.get(4).getSemaphore());
        philosophers.get(1).setLeftPhilosopher(philosophers.get(2).getSemaphore());
        philosophers.get(1).setRightPhilosopher(philosophers.get(0).getSemaphore());
        philosophers.get(2).setLeftPhilosopher(philosophers.get(3).getSemaphore());
        philosophers.get(2).setRightPhilosopher(philosophers.get(1).getSemaphore());
        philosophers.get(3).setLeftPhilosopher(philosophers.get(4).getSemaphore());
        philosophers.get(3).setRightPhilosopher(philosophers.get(2).getSemaphore());
        philosophers.get(4).setLeftPhilosopher(philosophers.get(0).getSemaphore());
        philosophers.get(4).setRightPhilosopher(philosophers.get(3).getSemaphore());
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}