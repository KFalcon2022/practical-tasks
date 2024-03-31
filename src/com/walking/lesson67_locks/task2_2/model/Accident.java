package com.walking.lesson67_locks.task2_2.model;

import java.time.LocalDate;
import java.util.Objects;

public class Accident {
    private final String name;
    private final AccidentIdentificator accidentIdentificator;

    private String accidentCause;
    private int victimsNumber;
    private LocalDate updated;

    public Accident(String name, AccidentIdentificator accidentIdentificator) {
        this.name = name;
        this.accidentIdentificator = accidentIdentificator;
    }

    public Accident(String name, AccidentIdentificator accidentIdentificator, LocalDate updated) {
        this(name, accidentIdentificator);
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return Objects.equals(accidentIdentificator, accident.accidentIdentificator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidentIdentificator);
    }

    @Override
    public String toString() {
        return "Accident {" +
                "name: '" + name + '\'' +
                ", " + accidentIdentificator +
                ", updated: " + updated +
                ", cause: " + accidentCause +
                ", victims: " + victimsNumber +
                '}';
    }

    public AccidentIdentificator getAccidentIdentificator() {
        return accidentIdentificator;
    }

    public void setAccidentCause(String accidentCause) {
        this.accidentCause = accidentCause;
    }

    public void setVictimsNumber(int victimsNumber) {
        this.victimsNumber = victimsNumber;
    }

    public LocalDate getUpdated() {
        return updated;
    }
}
