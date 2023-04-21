package com.walking.lesson68.task1;

import com.walking.lesson68.task1.model.Philosopher;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore fork1 = new Semaphore(1);
        Semaphore fork2 = new Semaphore(1);
        Semaphore fork3 = new Semaphore(1);
        Semaphore fork4 = new Semaphore(1);
        Semaphore fork5 = new Semaphore(1);

        Philosopher philosopher1 = new Philosopher(fork1, fork2);
        Philosopher philosopher2 = new Philosopher(fork2, fork3);
        Philosopher philosopher3 = new Philosopher(fork3, fork4);
        Philosopher philosopher4 = new Philosopher(fork4, fork5);
        Philosopher philosopher5 = new Philosopher(fork5, fork1);

        new Thread(philosopher1).start();
        new Thread(philosopher2).start();
        new Thread(philosopher3).start();
        new Thread(philosopher4).start();
        new Thread(philosopher5).start();

    }
}
