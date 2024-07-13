package com.walking.lesson41_set.task1.model;

import java.time.Instant;
import java.util.Objects;

public class Task implements Comparable<Task> {
    private final String name;
    private Instant acceptedAt;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Instant getAcceptedAt() {
        return acceptedAt;
    }

    public void setAcceptedAt(Instant acceptedAt) {
        this.acceptedAt = acceptedAt;
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
        return acceptedAt.compareTo(o.getAcceptedAt());
    }
}