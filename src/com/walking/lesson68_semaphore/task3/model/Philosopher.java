package com.walking.lesson68_semaphore.task3.model;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Philosopher {
    private final int id;
    private final SortedSet<Integer> forkNumbers;

    private int lunchCounter;

    public Philosopher(int id, Set<Integer> forkNumbers) {
        this.id = id;
        this.forkNumbers = new TreeSet<>(forkNumbers);
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    public int getId() {
        return id;
    }

    public SortedSet<Integer> getForkNumbers() {
        return forkNumbers;
    }

    public int getLunchCounter() {
        return lunchCounter;
    }

    public void increaseLunchCounter() {
        lunchCounter++;
    }
}
