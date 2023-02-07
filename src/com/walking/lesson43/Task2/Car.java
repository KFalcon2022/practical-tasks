package com.walking.lesson43.Task2;

public class Car {
    public final String number;
    public String owner;

    public Car(String number) {
        this.number = number;
    }

    public Car(String number, String owner) {
        this(number);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        return hashCode() == o.hashCode();
    }

    @Override
    public String toString() {
        return "Number: \"%s\", Owner: %s".formatted(number, owner);
    }
}
