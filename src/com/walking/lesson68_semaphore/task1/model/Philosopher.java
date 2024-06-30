package com.walking.lesson68_semaphore.task1.model;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private final String name;
    private final Semaphore semaphore;

    private final int id;
    private int num = 0;

    public Philosopher(String name, Semaphore semaphore, int id) {
        this.name = name;
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (num < 3) {
                semaphore.acquire(2);
                System.out.printf("%s %d садится за стол.\n", name, id);

                takeLeftFork();
                takeRightFork();

                System.out.printf("%s %d ест.\n", name, id);
                num++;
                sleep(500);

                putLeftFork();
                putRightFork();

                System.out.printf("%s %d выходит из за стола.\n", name, id);
                semaphore.release(2);

                sleep(500);
                System.out.printf("%s %d размышляет.\n", name, id);
            }
        } catch (InterruptedException e) {
            System.out.printf("У %s %d проблемы со здоровьем.\n", name, id);
        }
    }

    private void takeLeftFork() {
        System.out.printf("%s %d взял левую вилку.\n", name, id);
    }

    private void takeRightFork() {
        System.out.printf("%s %d взял правую вилку.\n", name, id);
    }

    private void putLeftFork() {
        System.out.printf("%s %d положил левую вилку.\n", name, id);
    }

    private void putRightFork() {
        System.out.printf("%s %d положил правую вилку.\n", name, id);
    }
}
