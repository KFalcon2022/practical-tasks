package com.walking.lesson43_map.task2.model;

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

    public static MarkType getMark(String mark) {
        for (var i : values()) {
            if (i.name.equals(mark)) {
                return i;
            }
        }

        return null;
    }
}
