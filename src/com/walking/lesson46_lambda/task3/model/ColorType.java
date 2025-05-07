package com.walking.lesson46_lambda.task3.model;

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

    public static ColorType setColor(String color) {
        for (var i : values()) {
            if (i.name.equals(color)) {
                return i;
            }
        }

        return null;
    }
}
