package com.walking.lesson12_inkapsulyaciya.service;

import com.walking.lesson12_inkapsulyaciya.model.Counter;

public class CounterService {
    Counter[] counters;

    public CounterService(Counter[] counters) {
        this.counters = counters;
    }

    public Counter[] getAllCounters() {
        return counters;
    }

    public Counter getCounterByName(String name) {
        for (Counter counter : counters) {
            if (counter.getName().equals(name)) {
                return counter;
            }
        }
        return null;
    }

    public int increase(Counter counter, int value) {
        counter.setCount(counter.getCount() + value);
        return counter.getCount();
    }

    public int decrease(Counter counter, int value) {
        counter.setCount(counter.getCount() - value);
        return counter.getCount();
    }

    public int increment(Counter counter){
        counter.setCount(counter.getCount() + 1);
        return counter.getCount();
    }

    public int decrement(Counter counter) {
        counter.setCount(counter.getCount() - 1);
        return counter.getCount();
    }

    public void resetCounter(Counter counter) {
        counter.setCount(0);
    }
}
