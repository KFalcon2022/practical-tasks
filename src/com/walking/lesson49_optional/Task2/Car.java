package com.walking.lesson49_optional.Task2;

public class Car {
    private final String number;
    private final Integer year;
    private Person owner;

    public Car(String number, Integer year, Person owner) {
        this.number = number;
        this.year = year;
        this.owner = owner;
        this.owner.setCar(this);
    }

    public String getNumber() {
        return number;
    }

    public Integer getYear() {
        return year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
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
        return "Number: \"%s\", Owner: %s, %s, %s".formatted(number, owner.getName(), owner.getPosition(), owner.getAddress());
    }
}
