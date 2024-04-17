package com.walking.lesson12_inkapsulyaciya.model;

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
}
