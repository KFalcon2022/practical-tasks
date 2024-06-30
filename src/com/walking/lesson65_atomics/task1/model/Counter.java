package com.walking.lesson65_atomics.task1.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger();

    private final String name;
    private final String unit;

    public Counter(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public Counter(String name, String unit, AtomicInteger value) {
        this.name = name;
        this.unit = unit;
        this.atomicInteger = value;
    }

    public AtomicInteger getValue() {
        return atomicInteger;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int increment() {
        return atomicInteger.incrementAndGet();
    }

    public int decrement() {
        return atomicInteger.decrementAndGet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter = (Counter) o;
        return Objects.equals(getName(), counter.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    private int reset() {
        return atomicInteger.addAndGet(0);
    }
}
