package com.walking.lesson6_methods;

import java.util.Scanner;

/**
 * �������� ���������, ������� ��������� ����� � ������ �������������� (2 ����� �����).
 * ���������� � ������� �������� �������������, ��������� �-� � �|�.
 * ���� �������������� ���������� �������� � �.
 * ������ ������� ����� ������ ������������ ����� �������� �-�,
 * ������ ������� ������ � �������� �|�.
 * <p>
 * ���������� ������������ �� ������ ����������. ���������� ������� �� ��������. ������� ����.
 */
public class Task3 {
    public static final String CORNER = " ";
    public static final String HORIZONTAL_LINE = "�";
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
