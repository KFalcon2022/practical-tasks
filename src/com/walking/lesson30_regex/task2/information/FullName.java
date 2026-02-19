package com.walking.lesson30_regex.task2.information;

public class FullName {
    private final String firstName;
    private final String surname;
    private final String fathersName;

    public FullName(String firstName, String surname, String fathersName) {
        this.firstName = firstName;
        this.surname = surname;
        this.fathersName = fathersName;
    }

    @Override
    public String toString() {
        return "%s %s %s".formatted(surname, firstName, fathersName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFathersName() {
        return fathersName;
    }
}
