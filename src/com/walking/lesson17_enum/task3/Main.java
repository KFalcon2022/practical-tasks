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

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();


        EquilateralShape shape = selectShapeType(shapeType);
        System.out.println(shape.createShapeString(length));
    }

    public static EquilateralShape selectShapeType(int shapeType){
        if(shapeType == 1){
            return EquilateralShape.SQUARE;
        } if (shapeType == 2) {
            return EquilateralShape.EQUILATERALTRIANGLE;
        } return null;
    }
}
