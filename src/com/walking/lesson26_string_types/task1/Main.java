package com.walking.lesson26_string_types.task1;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson6_methods/Task3.java">...</a>
 * используя StringBuilder или StringBuffer. Объясните свой выбор.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину прямоугольника целым числом: ");
        int rectWidth = scanner.nextInt();
        System.out.print("Введите высоту прямоугольника целым числом: ");
        int rectHeight = scanner.nextInt();
        scanner.close();

        System.out.println(drawRect(rectWidth, rectHeight));
    }

    private static StringBuilder drawRect(int w, int h) {
        StringBuilder result = new StringBuilder();
        result.append(drawHorizontLines(w));
        result.append(drawVerticalLines(w, h));
        result.append(drawHorizontLines(w));
        return result;
    }

    public static StringBuilder drawVerticalLines(int rectWidth, int rectHeight) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < rectHeight; i++ ) {
            result.append("|");
            for (int j = 0; j < rectWidth; j++) {
                result.append(" ");
            }
            result.append("|\n");
        }
        return result;
    }

    public static StringBuilder drawHorizontLines(int rectWidth) {
        StringBuilder result = new StringBuilder();

        // j < rectWidth + 2 -- +2 т.к. 2 угла. в условии сказано: Углы прямоугольника обозначить символом “ “.
        for (int j = 0; j < rectWidth + 2; j++) {
            if (j == 0 || j == rectWidth + 1) {
                result.append(" ");
            } else {
                result.append("-");
            }
        }
        result.append("\n");
        return result;
    }
}
