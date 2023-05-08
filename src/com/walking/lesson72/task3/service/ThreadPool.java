package com.walking.lesson72.task3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private final Random random = new Random();
    private final BlockingQueue<Integer> tasks = new ArrayBlockingQueue<>(10);
    private final List<Thread> producers = new ArrayList<>();
    private final List<Thread> consumers = new ArrayList<>();
    private final int CONSUMERS_COUNT = 4;
    private final int PRODUCERS_COUNT = 1;

    public ThreadPool() {
        init(PRODUCERS_COUNT, CONSUMERS_COUNT);
    }

    public void start() {

        if (producers.size() < 1 || consumers.size() < 1) {
            throw new IllegalStateException("There must be at least 1 consumer and producer thread. Consider to init the thread pool");
        }

        for (Thread producer : producers) {
            producer.start();
        }

        for (Thread consumer : consumers) {
            consumer.start();
        }
    }

    private void init(int producersCount, int consumersCount) {
        for (int i = 0; i < producersCount; i++) {
            producers.add(new Thread(getProducer()));
        }
        for (int i = 0; i < consumersCount; i++) {
            consumers.add(new Thread(getConsumer()));
        }
    }

    private Runnable getProducer() {
        return () -> {
            try {
                while (true) {
                    tasks.put(random.nextInt(10));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private Runnable getConsumer() {
        return () -> {
            try {
                while (true) {
                    Integer task = tasks.take();
                    System.out.printf("Thread %s executes task %d%n", Thread.currentThread().getName(), task);
                    Thread.sleep(task * 1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
