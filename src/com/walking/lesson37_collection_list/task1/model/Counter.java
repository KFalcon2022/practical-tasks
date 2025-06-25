package com.walking.lesson37_collection_list.task1.model;

import java.util.Objects;

public class Counter implements Comparable<Counter> {
    private final String name;
    private final String unitOfMeasure;

    private int value;

    public Counter(String name, String unitOfMeasure, int value) {
        this.name = name;
        this.unitOfMeasure = unitOfMeasure;
        this.value = value;
    }

    public Counter(String name, String unitOfMeasure) {
        this(name, unitOfMeasure, 0);
    }

    public String getName() {
        return name;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Counter counter) {
        return name.compareTo(counter.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Counter counter = (Counter) o;
        return Objects.equals(name, counter.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}