package com.walking.lesson12_counterAggregation.model;

public class CounterService {
    private final Counter[] counters = new Counter[4];

    public void getAvailableCounters() {
        System.out.println("Доступные счетчики:");
        if (counters[0] == null) {
            System.out.println("Доступных счетчиков нет!");
            return;
        }
        for (Counter counter : counters) {
            if (counter != null) {
                System.out.println(counter.getName());
            }
        }
    }

    public Counter getCounterByName(String name) {
        for (Counter counter : counters) {
            if (counter != null && counter.getName().equals(name)) {
                return counter;
            }
        }
        return null;
    }

    public void incrementCounter(Counter counter) {
        counter.incrementCounter();
    }

    public void decrementCounter(Counter counter) {
        counter.decrementCounter();
    }

    public void increaseCounter(Counter counter, int quantity) {
        counter.increaseCounter(quantity);
    }

    public void decreaseCounter(Counter counter, int quantity) {
        counter.decreaseCounter(quantity);
    }

    public void clearCounter(Counter counter) {
        counter.decreaseCounter(counter.getCount());
    }

    public Counter[] getCounters() {
        return counters;
    }
}
