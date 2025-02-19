package com.walking.lesson30_regex.task2;

public class FullName {
    private final String SURNAME;
    private final String NAME;
    private final String PATRONYMIC;

    public FullName(String SURNAME, String NAME, String PATRONYMIC) {
        this.SURNAME = SURNAME;
        this.NAME = NAME;
        this.PATRONYMIC = PATRONYMIC;
    }

    @Override
    public String toString() {
        return (SURNAME + " " + NAME + " " + PATRONYMIC);
    }
}
