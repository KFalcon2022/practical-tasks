package com.walking.lesson40_queue2.models;

import java.time.LocalDateTime;

public class Task implements Comparable<Task> {
    private final String NAME;
    private final long ID;
    private String description;
    private final LocalDateTime TIME_OF_CREATION;

    public Task(String name){
        this.NAME =name;
        ID=hashCode();
        this.TIME_OF_CREATION=LocalDateTime.now();
    }
    public Task (String name, String description){
        this(name);
        this.description=description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getNAME(){return NAME;}

    public long getID() {
        return ID;
    }

    public LocalDateTime getTIME_OF_CREATION() {
        return TIME_OF_CREATION;
    }

    @Override
    public int compareTo(Task o) {
        return TIME_OF_CREATION.compareTo(o.TIME_OF_CREATION);
    }
}
