package com.walking.lesson26_string_types.task1.service;

public class Rectangle {
    private int length;
    private int width;

    private final String SPACE = " ";
    private final String LENGTH_SYMBOL = "-";
    private final String WIDTH_SYMBOL = "|";

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    /**
     * как я поняла, StringBuilder быстрее работает,
     * а плюсы StringBuffer'а только в условиях многопоточности раскрываются, что, вроде, не про эту задачу.
     * поэтому использовала StringBuilder
     * P.S. может, перемудрила с классами, но мне захотелось попробовать поприменять из прошлых уроков штуки:)
     */

    public StringBuilder getRectangle() {
        StringBuilder rectangle = getLine(SPACE, LENGTH_SYMBOL);
        for (int i = 0; i < width - 2; i++) {
            rectangle.append(getLine(WIDTH_SYMBOL, SPACE));
        }
        return rectangle.append(getLine(SPACE, LENGTH_SYMBOL));
    }

    private StringBuilder getLine(String side, String center) {
        StringBuilder horizontal = new StringBuilder(side);
        horizontal.append(center.repeat(length - 2));

        return horizontal.append(side).append("\n");
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
