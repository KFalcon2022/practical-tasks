package com.walking.lesson30_regex.task2.model;

public class FullName {
    private final String lastName;
    private final String firstName;
    private final String patronymic;

    public FullName(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        return "%s %s %s".formatted(lastName, firstName, patronymic);
    }
}
