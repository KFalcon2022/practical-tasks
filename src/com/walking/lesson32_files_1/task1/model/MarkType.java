package com.walking.lesson32_files_1.task1.model;

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
}
