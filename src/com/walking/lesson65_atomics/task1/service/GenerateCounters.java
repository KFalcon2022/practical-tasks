package com.walking.lesson65_atomics.task1.service;

import com.walking.lesson65_atomics.task1.model.Counter;

import java.util.ArrayList;
import java.util.List;

public class GenerateCounters {
    private final List<Counter> counters;

    public GenerateCounters() {
        counters = new ArrayList<>();
        generate();
    }

    public List<Counter> getCounters() {
        return counters;
    }

    private void generate() {
        counters.add(new Counter("Counter 1"));
        counters.add(new Counter("Counter 2"));
        counters.add(new Counter("Counter 3"));
        counters.add(new Counter("Counter 4"));
        counters.add(new Counter("Counter 5"));
        counters.add(new Counter("Counter 6"));
        counters.add(new Counter("Counter 7"));
        counters.add(new Counter("Counter 8"));
        counters.add(new Counter("Counter 9"));
        counters.add(new Counter("Counter 10"));
    }
}
