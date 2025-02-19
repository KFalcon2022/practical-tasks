package com.walking.lesson38_comparing.task1.model;

public enum MarkType {
    AUDI("Audi"),
    BMW("BMW"),
    VOLVO("Volvo"),
    LADA("Lada"),
    SUZUKI("Suzuki"),
    RENAULT("Renault"),
    KIA("Kia"),
    MAZDA("Mazda");

    private final String name;

    MarkType(String name) {
        this.name = name;
    }

    public static MarkType setMark(String mark) {
        for (var i : values()) {
            if (i.name.equals(mark)) {
                return i;
            }
        }

        return null;
    }
}
