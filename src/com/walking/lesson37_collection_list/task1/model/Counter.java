package com.walking.lesson37_collection_list.task1.model;

public class Counter {
    private final String name;
    private final String unit;

    private int value;

    public Counter(String name, String unit) {
        this(name, unit, 0);
    }

    public Counter(String name, String unit, int value) {
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getValue() {
        return value;
    }
}

