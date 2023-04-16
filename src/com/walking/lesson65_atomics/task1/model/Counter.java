package com.walking.lesson65_atomics.task1.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    //    В рамках данной задачи будем считать имя счетчика уникальным
    private final String name;
    private final String unit;
    private final AtomicInteger value;

    public Counter(String name, String unit) {
        this(name, unit, new AtomicInteger());
    }

    public Counter(String name, String unit, AtomicInteger value) {
        this.value = value;
        this.unit = unit;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public AtomicInteger getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter = (Counter) o;
        return Objects.equals(name, counter.name); // в данном случае будем определять уникальность счетчика на базе name
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
