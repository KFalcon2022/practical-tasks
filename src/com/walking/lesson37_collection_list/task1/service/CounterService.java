package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.ArrayList;
import java.util.List;

public class CounterService {
    private List<Counter> countersList;

    public CounterService(List<Counter> counters) {
        this.countersList = new ArrayList<>(counters);
    }

    public List<Counter> getAllCounters() {
        return countersList;
    }

    public void add(Counter counter) {
        countersList.add(counter);
    }

    public Counter increase(Counter counter, int value) {
        counter.setCount(counter.getCount() + value);
        return counter;
    }

    public Counter increase(String name, int value) {
        if (getCounterByName(name) == null) {
            return null;
        }
        Counter counter = getCounterByName(name);
        counter.setCount(counter.getCount() + value);
        return counter;
    }

    public Counter decrease(Counter counter, int value) {
        counter.setCount(counter.getCount() - value);
        return counter;
    }

    public Counter decrease(String name, int value) {
        if (getCounterByName(name) == null) {
            return null;
        }
        Counter counter = getCounterByName(name);
        counter.setCount(counter.getCount() - value);
        return counter;
    }

    public Counter increment(Counter counter) {
        counter.setCount(counter.getCount() + 1);
        return counter;
    }

    public Counter increment(String name) {
        if (getCounterByName(name) == null) {
            return null;
        }
        Counter counter = getCounterByName(name);
        counter.setCount(counter.getCount() + 1);
        return counter;
    }

    public Counter decrement(Counter counter) {
        counter.setCount(counter.getCount() - 1);
        return counter;
    }

    public Counter decrement(String name) {
        if (getCounterByName(name) == null) {
            return null;
        }
        Counter counter = getCounterByName(name);
        counter.setCount(counter.getCount() - 1);
        return counter;
    }

    public Counter resetCounter(Counter counter) {
        counter.setCount(0);
        return counter;
    }

    public Counter resetCounter(String name) {
        if (getCounterByName(name) == null) {
            return null;
        }
        Counter counter = getCounterByName(name);
        counter.setCount(0);
        return counter;
    }

    private Counter getCounterByName(String name) {
        for (Counter counter : countersList) {
            if (counter.getName().equals(name)) {
                return counter;
            }
        }

        return null;
    }
}
