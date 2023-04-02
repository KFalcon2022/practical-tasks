package com.walking.lesson60_thread.task4;

/**
 * Решите Задачу 3, не используя Thread.join().
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        var callableThread = new CallableThread<>(() -> Thread.currentThread().getName());
        callableThread.start();
        System.out.println(callableThread.getResult());

        callableThread = new CallableThread<>(() -> Thread.currentThread().getName());
        System.out.println(callableThread.startAndGet());
    }
}