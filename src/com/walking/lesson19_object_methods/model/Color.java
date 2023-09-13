package com.walking.lesson19_object_methods.model;

public class Color {
    private String[] colorsArray = {
            "Белый",
            "Черный",
            "Синий",
            "Красный",
            "Серый",
            "Зеленый",
            "Желтый"
    };

    public String setColor() {
        return colorsArray[(int) (Math.random() * colorsArray.length)];
    }
}
