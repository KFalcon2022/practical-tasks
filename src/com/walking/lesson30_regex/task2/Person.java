package com.walking.lesson30_regex.task2;

public class Person {
    private String name;
    private String fName;
    private String surname;

    public Person(String surname, String name, String fName) {
        this.name = name;
        this.fName = fName;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getfName() {
        return fName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return getSurname() + ' ' + getName() + ' ' + getfName();
    }
}
