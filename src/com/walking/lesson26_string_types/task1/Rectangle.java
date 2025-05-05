package com.walking.lesson26_string_types.task1;

public class Rectangle {
    private final String lengthElement = "-";
    private final String widthElement = "|";
    private final String spaceElement = " ";

    private final StringBuilder rectangle = new StringBuilder();


    private void createHorizontalLine(int length) {
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) {
                rectangle.append(spaceElement);
            } else {
                rectangle.append(lengthElement);
            }
        }
        rectangle.append("\n");
    }

    private void createVerticalLines(int length, int width) {

        for (int i = 0; i < width - 2; i++) {
            for (int j = 0; j < length; j++) {
                if (j == 0 || j == length - 1) {
                    rectangle.append(widthElement);
                } else {
                    rectangle.append(spaceElement);
                }
            }
            rectangle.append("\n");
        }
    }

    public StringBuilder createRectangle(int length, int width) {
        createHorizontalLine(length);
        createVerticalLines(length, width);
        createHorizontalLine(length);
        return rectangle;
    }
}
