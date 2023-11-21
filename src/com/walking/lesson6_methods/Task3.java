package com.walking.lesson6_methods;

import java.util.Scanner;

/**
 * Ќаписать программу, котора€ принимает длину и ширину пр€моугольника (2 целых числа).
 * Ќарисовать в консоли заданный пр€моугольник, использу€ У-У и У|Ф.
 * ”глы пр€моугольника обозначить символом У У.
 *  ажда€ единица длины должна обозначатьс€ одним символом У-У,
 * кажда€ единица ширины Ц символом У|У.
 * <p>
 * ѕроизвести декомпозицию по своему усмотрению. –екомендую скинуть на проверку.  онтакт ниже.
 */
public class Task3 {
    public static final String CORNER = " ";
    public static final String HORIZONTAL_LINE = "Ч";
    public static final String VERTICAL_LINE = "|";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length: ");
        int length = scanner.nextInt();

        System.out.print("Enter height: ");
        int height = scanner.nextInt();

        scanner.close();

        draw(length, height);
    }

    static void draw(int x, int y) {
        drawTopAndDown(x);
        for (int i = 0; i < y; i++) {
            drawLeftAndRight(x);
        }
        drawTopAndDown(x);
    }

    private static void drawTopAndDown(int x) {
    System.out.print(CORNER);
        for (int i = 0; i < x; i++) {
            System.out.print(HORIZONTAL_LINE);
        }
        System.out.println(CORNER);
    }

    private static void drawLeftAndRight(int x) {
        System.out.print(VERTICAL_LINE);
        for (int i = 0; i < x; i++) {
            System.out.print(" ");
        }
        System.out.println(VERTICAL_LINE);
    }
}
