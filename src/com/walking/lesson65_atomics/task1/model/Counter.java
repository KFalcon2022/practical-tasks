package com.walking.lesson65_atomics.task1.model;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private final AtomicLong value = new AtomicLong(0);

    private final String name;
    private final int hashcode;

    public Counter(String name) {
        this.name = name;
        this.hashcode = hashCode();
    }

    public AtomicLong getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        Counter counter = (Counter) obj;

        return this.name.equals(counter.getName());
    }

    @Override
    public int hashCode() {
        if (hashcode == 0) {
            return name.hashCode();
        }

        return hashcode;
    }

    public String getName() {
        return name;
    }
}
