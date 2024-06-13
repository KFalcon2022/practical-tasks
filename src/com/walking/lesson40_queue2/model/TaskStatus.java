package com.walking.lesson40_queue2.model;

public enum TaskStatus {
    ACCEPTED,
    EXECUTED,
    CANCELED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}