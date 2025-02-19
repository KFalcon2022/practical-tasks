package com.walking.lesson19_object_methods.model;

public enum MarkList {
    AUDI("Audi"),
    BMW("BMW"),
    VOLVO("Volvo"),
    LADA("Lada"),
    SUZUKI("Suzuki"),
    RENAULT("Renault"),
    KIA("Kia"),
    MAZDA("Mazda");

    private final String name;

    MarkList(String name) {
        this.name = name;
    }

    public static MarkList setMark(String mark) {
        for (var i : values()) {
            if (i.name.equals(mark)) {
                return i;
            }
        }

        return null;
    }
}
