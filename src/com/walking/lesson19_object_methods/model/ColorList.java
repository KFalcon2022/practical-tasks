package com.walking.lesson19_object_methods.model;

public enum ColorList {
    WHITE("Белый"),
    BLACK("Черный"),
    BLUE("Синий"),
    RED("Красный"),
    GREY("Серый"),
    GREEN("Зеленый"),
    YELOW("Желтый");

    private final String name;

    ColorList(String name) {
        this.name = name;
    }

    public static ColorList setColor(String color) {
        for (var i : values()) {
            if (i.name.equals(color)) {
                return i;
            }
        }

        return null;
    }
}
