package com.walking.lesson65_atomics.task1.service;

import com.walking.lesson65_atomics.task1.model.Counter;

import java.util.*;

public class CounterService {
    private final Map<Integer, Counter> counterSet = new HashMap<>();

    public CounterService(Counter... counters) {
        for (Counter counter : counters) {
            counterSet.put(counter.hashCode(), counter);
        }
    }

    private synchronized boolean isCounterExist(Counter counter) {
        if (!counterSet.containsKey(counter.hashCode())) {
            System.out.println("Counter " + counter.getName() + " doesn't exist.");
            return false;
        }

        return true;
    }

    public synchronized void addCounter(Counter counter) {
        System.out.println("\nTrying to add " + counter.getName() + "...");

        if (counterSet.containsKey(counter.hashCode())) {
            System.out.println("\nCounter " + counter.getName() + " is already added.");
            return;
        }

        counterSet.put(counter.hashCode(), counter);
        System.out.println(counter.getName() + " was added");
    }

    public synchronized void deleteCounter(Counter counter) {
        System.out.println("\nTrying to delete " + counter.getName() + "...");

        if (isCounterExist(counter)) {
            counterSet.remove(counter.hashCode());
            System.out.println(counter.getName() + " was removed.");
        }
    }

    public synchronized void increase(Counter counter) {
        System.out.println("\nTrying to increase " + counter.getName() + "...");

        if (isCounterExist(counter)) {
            long resultValue = counterSet.get(counter.hashCode())
                    .getValue()
                    .incrementAndGet();

            System.out.println(counter.getName() + " was increased. New value: " + resultValue);
        }
    }

    public synchronized void decrease(Counter counter) {
        System.out.println("\nTrying to decrease " + counter.getName() + "...");

        if (isCounterExist(counter)) {
            long resultValue = counterSet.get(counter.hashCode())
                    .getValue()
                    .decrementAndGet();

            System.out.println(counter.getName() + " was decreased. New value: " + resultValue);
        }
    }

    public synchronized void clear(Counter counter) {
        System.out.println("\nTrying to clear " + counter.getName() + "...");

        if (isCounterExist(counter)) {
            long resultValue = counterSet.get(counter.hashCode())
                    .getValue()
                    .getAndSet(0);

            System.out.println(counter.getName() + " was cleared. Last value: " + resultValue);
        }
    }
}
