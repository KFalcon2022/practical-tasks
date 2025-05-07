package com.walking.lesson37_collection_list.task1.model;


import java.util.Formatter;

public class Counter {
    private final String name;
    private final String type;
    private int count;

    public Counter(String name, String type) {
        this.name = name;
        this.type = type;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "%s: %d %s".formatted(name, count, type);
    }
}
