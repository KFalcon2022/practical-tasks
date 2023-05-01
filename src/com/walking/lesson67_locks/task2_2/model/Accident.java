package com.walking.lesson67_locks.task2_2.model;

import java.time.LocalDateTime;

public class Accident {
    private final long id;
    private final LocalDateTime date;
    private final LocalDateTime updated;
    private final String details;

    public Accident(long id, LocalDateTime date, String details, LocalDateTime updated) {
        this.id = id;
        this.date = date;
        this.details = details;
        this.updated = updated;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
