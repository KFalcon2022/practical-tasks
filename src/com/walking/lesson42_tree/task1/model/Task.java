package com.walking.lesson42_tree.task1.model;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[%s]".formatted(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Task task = (Task) o;

        return Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Task o) {
        return name.compareTo(o.getName());
    }
}