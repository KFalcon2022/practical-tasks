package com.walking.lesson17_enum.task3;

import com.walking.lesson17_enum.task3.shape.EquilateralShapeType;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        if (length < 1 || (shapeType != 1 && shapeType != 2)) {
            System.out.println("Incorrect input.");
            return;
        }

        String shapeString = createShapeString(length, shapeType);
        System.out.println(shapeString);
    }

    private static String createShapeString(int length, int type) {
        EquilateralShapeType shapeType;

        switch (type) {
            case 1:
                shapeType = EquilateralShapeType.SQUARE;
                break;
            case 2:
                shapeType = EquilateralShapeType.EQUILATERAL_TRIANGLE;
                break;
            default:
                return "Unknown shape";
        }

        return shapeType.createShapeString(length);
    }
}
