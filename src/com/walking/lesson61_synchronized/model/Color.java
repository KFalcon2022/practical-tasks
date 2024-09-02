package com.walking.lesson61_synchronized.model;

import com.walking.lesson61_synchronized.exception.UnableParsingException;

public enum Color {
    BLACK("black"),
    WHITE("white"),
    RED("red"),
    YELLOW("yellow"),
    BLUE("blue"),
    GREEN("green"),
    ORANGE("orange"),
    INDIGO("indigo"),
    VIOLET("violet");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Color parseColorByName(String name) {
        for (Color color : Color.values()) {
            if (color.name.equals(name)) {
                return color;
            }
        }

        throw new UnableParsingException("Unable parse Color value:", name);
    }
}
