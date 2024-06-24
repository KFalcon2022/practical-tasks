package com.walking.lesson65_atomics.task1.service;

import com.walking.lesson65_atomics.task1.model.Counter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CounterStorageService {
    private final Map<String, Counter> counterByName = new HashMap<>();

    public synchronized Counter add(Counter counter) {
        return counterByName.compute(counter.getName(), (c1, c2) -> {
            if (c1 != null) {
                throw new RuntimeException("Counter already exists, name: '%s'".formatted(counter.getName()));
            }

            return c2;
        });
    }

    public synchronized void delete(String name) {
        counterByName.remove(name);
    }

    public synchronized Set<Counter> getAll() {
        return new HashSet<>(counterByName.values());
    }

    public synchronized Counter get(String name) {
        var counter = counterByName.get(name);

        if (counter == null) {
            throw new RuntimeException("Counter not found '%s'.".formatted(name));
        }

        return counter;
    }
}
