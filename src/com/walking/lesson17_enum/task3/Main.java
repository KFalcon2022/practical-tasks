package com.walking.lesson17_enum.task3;

import com.walking.lesson17_enum.task3.model.EquilateralShape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's type:\n 0: Triangle \n 1: Square\n ");
        int shapeType = scanner.nextInt();

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        if ((shapeType != 0 && shapeType != 1)) {
            System.out.println("Incorrect input");
            return;
        }

        printShape(shapeType, length);
    }

    private static void printShape(int type, int length) {

        for (EquilateralShape x : EquilateralShape.values()) {
            if (type == x.ordinal()) {
                System.out.println(x.createShapeString(length));
            }

        }
    }
}
