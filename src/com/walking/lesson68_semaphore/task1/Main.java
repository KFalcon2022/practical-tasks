package com.walking.lesson68_semaphore.task1;

import java.util.ArrayList;

import com.walking.lesson68_semaphore.task1.model.Broker;
import com.walking.lesson68_semaphore.task1.model.Fork;
import com.walking.lesson68_semaphore.task1.model.Philosopher;

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
        Broker broker=new Broker();
        ArrayList<Fork> forks=new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            forks.add(new Fork(i));
        }
        ArrayList<Philosopher> philosophers=new ArrayList<>(5);
        philosophers.add(new Philosopher("Sokrat", forks.get(0), forks.get(4), broker));
        philosophers.add(new Philosopher("Kant", forks.get(1), forks.get(0), broker));
        philosophers.add(new Philosopher("Izop", forks.get(2), forks.get(1), broker));
        philosophers.add(new Philosopher("Lokk", forks.get(3), forks.get(2), broker));
        philosophers.add(new Philosopher("Platon", forks.get(4), forks.get(3), broker));
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}