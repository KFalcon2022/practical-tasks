package com.walking.lesson32_files_1.task1.model;

public enum ColorType {
    WHITE("Белый"),
    BLACK("Черный"),
    BLUE("Синий"),
    RED("Красный"),
    GREY("Серый"),
    GREEN("Зеленый"),
    YELOW("Желтый");

    private final String name;

    ColorType(String name) {
        this.name = name;
    }
}
