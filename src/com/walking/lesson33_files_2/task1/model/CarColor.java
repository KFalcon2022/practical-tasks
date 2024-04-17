package com.walking.lesson33_files_2.task1.model;

public enum CarColor {
    BLACK("black"),
    WHITE("white"),
    RED("red"),
    YELLOW("yellow"),
    BLUE("blue"),
    GREEN("green"),
    ORANGE("orange"),
    INDIGO("indigo"),
    VIOLET("violet");

    private final String textEn;

    CarColor(String textEn) {
        this.textEn = textEn;
    }

    public String getTextEn() {
        return textEn;
    }
}
