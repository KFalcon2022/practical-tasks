package com.walking.lesson41_set.task1.model;

import org.jetbrains.annotations.NotNull;

public class Task implements Comparable<Task> {
    private final String name;
    private int index;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(@NotNull Task o) {
        return Integer.compare(index, o.getIndex());
    }
}
