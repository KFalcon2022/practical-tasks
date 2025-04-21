package com.walking.lesson17_enum.task3;

import com.walking.lesson17_enum.task3.model.DataRequire;
import com.walking.lesson17_enum.task3.model.EquiliteralShape;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {

        System.out.print("Enter shape's type:\n 0: Triangle \n 1: Square\n ");
        int shapeType = DataRequire.requireInt();

        System.out.print("Enter shape's length: ");


        if ((shapeType != 0 && shapeType != 1)) {
            System.out.println("Incorrect input");
            return;
        }

        printShape(shapeType);
    }

    private static void printShape(int type) {

        for (EquiliteralShape x : EquiliteralShape.values()) {
            if (type == x.ordinal()) {
                System.out.println(x.createShapeString());
            }

        }
    }
}
