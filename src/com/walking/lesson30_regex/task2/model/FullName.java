package com.walking.lesson30_regex.task2.model;

public class FullName {
    private final String name;
    private final String surname;
    private final String patronymic;

    public FullName (String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public FullName(String [] arrayFullName) {
        this.surname = arrayFullName[0];
        this.name = arrayFullName[1];
        this.patronymic = arrayFullName[2];
    }

}
