package com.walking.lesson30_regex.task2.model;

public class FullName {
    private final String lastName;
    private final String patronymic;
    private final String firstName;

    public FullName(String lastName, String patronymic, String firstName) {
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFirstName() {
        return firstName;
    }
}
