package com.walking.lesson41_set.task1.model;

import java.util.Objects;

public class Task {

    private final String title;
    private String description;

    public Task(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        return title.equals(task.title);
    }

    @Override
    public int hashCode() {
        return 31 * title.hashCode();
    }
}
