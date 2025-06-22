package com.walking.lesson30_regex.task2.information;

public class FullName {
    private final String firstName;
    private final String secondName;
    private final String fathersName;

    public FullName(String firstName, String secondName, String fathersName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fathersName = fathersName;
    }

    @Override
    public String toString() {
        return "%s %s %s".formatted(secondName, firstName, fathersName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFathersName() {
        return fathersName;
    }
}
