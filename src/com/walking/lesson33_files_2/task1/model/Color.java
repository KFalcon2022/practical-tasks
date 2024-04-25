package com.walking.lesson33_files_2.task1.model;

import com.walking.lesson33_files_2.task1.exception.UnableParsingException;

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
        return switch (name) {
            case "black" -> Color.BLACK;
            case "white" -> Color.WHITE;
            case "red" -> Color.RED;
            case "yellow" -> Color.YELLOW;
            case "blue" -> Color.BLUE;
            case "green" -> Color.GREEN;
            case "orange" -> Color.ORANGE;
            case "indigo" -> Color.INDIGO;
            case "violet" -> Color.VIOLET;

            default -> throw new UnableParsingException("Unable parse Color value:", name);
        };
    }
}
