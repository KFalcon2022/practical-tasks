package com.walking.lesson30_regex.task2.model;

public class FullName {
    private String name;
    private String surname;
    private String patronymic;

    public FullName() {
    }

    public FullName(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "%s %s %s".formatted(surname, name, patronymic);
    }
}
