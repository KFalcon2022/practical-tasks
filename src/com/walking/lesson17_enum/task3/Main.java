package com.walking.lesson17_enum.task3;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shape's type:\n 1. Triangle\n 2.Square");
        int shapeType = scanner.nextInt();

        System.out.println("Enter size: ");
        int size = scanner.nextInt();
        scanner.close();

        System.out.println(createShapeString(shapeType, size));

    }

    private static String createShapeString(int shapeType, int size) {
        EquilateralShapeType shape;

        switch (shapeType) {
            case 1 -> shape = EquilateralShapeType.TRIANGLE;
            case 2 -> shape = EquilateralShapeType.SQUARE;
            default -> {
                return "Unknown shape";
            }
        }
        return shape.createShapeString(size);
    }
}
