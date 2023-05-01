package com.walking.lesson68_semaphore.task1.model;

import java.util.concurrent.locks.Lock;

public class Philosopher {
    private final String name;
    //    Вилка будет выступать локом. В целом, подошел бы и AtomicBoolean или отдельный класс,
//    но это потребовало бы описывать логику взятия вилки/опроса доступности вилки
    private final Lock leftFork;
    private final Lock rightFork;

    private int eatenCounter;

    public Philosopher(String name, Lock leftFork, Lock rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public String getName() {
        return name;
    }

    public Lock getLeftFork() {
        return leftFork;
    }

    public Lock getRightFork() {
        return rightFork;
    }

    public int getEatenCounter() {
        return eatenCounter;
    }

    public void setEatenCounter(int eatenCounter) {
        this.eatenCounter = eatenCounter;
    }
}
