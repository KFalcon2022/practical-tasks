package com.walking.lesson41_set.task1.model;

public enum TaskStatus {
    ACCEPTED,
    EXECUTED,
    CANCELED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}