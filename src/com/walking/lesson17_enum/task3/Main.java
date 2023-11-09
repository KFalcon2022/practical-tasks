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
        Scanner in = new Scanner(System.in);
        System.out.print("Enter length:");
        int length = in.nextInt();

        System.out.println("Enter shape: \n1. Triangle \n2. Square");
        int choiceShape = in.nextInt();

        in.close();
        String shapeString = createShapeString(length,choiceShape);
        System.out.print(shapeString);

    }
    private static String createShapeString(int length, int choiceShape) {
        EquilateralShape shape;
        switch (choiceShape) {
            case 1:
                shape = EquilateralShape.Triagle;
                break;
            case 2:
                shape = EquilateralShape.Square;
                break;
            default:
                return "Unknown shape";
        }

        return shape.getStringShape(length);
    }
}
