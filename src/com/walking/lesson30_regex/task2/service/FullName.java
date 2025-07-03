package com.walking.lesson30_regex.task2.service;

public class FullName {
    private final String name;
    private final String surname;
    private final String patronymic;

    public FullName(String surname, String name, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void printFullName() {
        System.out.println(surname + " " + name + " " + patronymic);
    }
}
