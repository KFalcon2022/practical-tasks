package com.walking.lesson68_semaphore.task3.model;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Philosopher {
    private final String name;
    private final SortedSet<Integer> forkNumbers = new TreeSet<>();

    private int eatenCounter;

    public Philosopher(String name, Set<Integer> forkNumbers) {
        this.name = name;
        this.forkNumbers.addAll(forkNumbers);
    }

    public String getName() {
        return name;
    }

    public SortedSet<Integer> getForkNumbers() {
        return forkNumbers;
    }

    public int getEatenCounter() {
        return eatenCounter;
    }

    public void setEatenCounter(int eatenCounter) {
        this.eatenCounter = eatenCounter;
    }
}
