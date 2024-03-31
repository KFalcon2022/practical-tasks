package com.walking.lesson67_locks.task2_1.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AccidentIdentificator {
    private final long ID;
    private final LocalDate date;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public String toString() {
        return "ID: " + ID +
                ", dateTime: " + date.format(formatter);
    }

    public AccidentIdentificator(long ID, LocalDate date) {
        this.ID = ID;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccidentIdentificator that = (AccidentIdentificator) o;
        return ID == that.ID && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, date);
    }
}
