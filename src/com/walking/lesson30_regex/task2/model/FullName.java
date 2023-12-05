package com.walking.lesson30_regex.task2.model;

public class FullName {
    private final String surname;
    private final String name;
    private final String patronymic;

    public FullName(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }
}
