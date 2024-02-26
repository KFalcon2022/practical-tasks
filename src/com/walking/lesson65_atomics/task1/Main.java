package com.walking.lesson65_atomics.task1;

import com.walking.lesson65_atomics.task1.model.Counter;
import com.walking.lesson65_atomics.task1.service.CounterService;
import com.walking.lesson65_atomics.task1.service.GenerateCounters;

import java.util.List;
import java.util.Random;

/**
 * Реализуйте сервис управления счетчиками.
 * Счетчики могут добавляться и удаляться,
 * в самих счетчиках могут изменяться значения – как увеличиваться,
 * так и уменьшаться. Также возможен сброс счетчика до 0 (нуля).
 * <p>
 * Гарантируйте возможность безопасной работы с данным сервисом.
 */
public class Main {
    private static final CounterService counterService = new CounterService();
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        GenerateCounters generateCounters = new GenerateCounters();
        List<Counter> counters = generateCounters.getCounters();
        counters.stream()
                .map(Main::addingTask)
                .forEach(r -> new Thread(r).start());

        new Thread(deletingTask(new Counter("Counter 1"))).start();
        new Thread(deletingTask(new Counter("Counter 5"))).start();

        Thread.sleep(100);
        new Thread(deletingTask(new Counter("Counter 6"))).start();

        counters.stream()
                .map(Main::increasingTask)
                .forEach(Main::startThreads);

        counters.stream()
                .map(Main::decreaseTask)
                .forEach(Main::startThreads);
    }

    private static void startThreads(Runnable runnable) {

        for (int i = 0; i < random.nextInt(8, 25); i++) {
            new Thread(runnable).start();
        }
    }

    private static Runnable addingTask(Counter counter) {
        return () -> counterService.addCounter(counter);
    }

    private static Runnable deletingTask(Counter counter) {
        return () -> counterService.deleteCounter(counter);
    }

    private static Runnable increasingTask(Counter counter) {
        return () -> counterService.increase(counter);
    }

    private static Runnable decreaseTask(Counter counter) {
        return () -> counterService.decrease(counter);
    }
}