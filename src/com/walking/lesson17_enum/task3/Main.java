package com.walking.lesson17_enum.task3;


import com.walking.lesson17_enum.task3.model.EquilateralShape;
import com.walking.lesson17_enum.task3.validators.LengthValidator;
import com.walking.lesson17_enum.task3.validators.ShapeTypeValidator;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shape's length: ");
        int length = scanner.nextInt();
        LengthValidator lengthValidator = new LengthValidator(length);

        boolean lengthIsValid = lengthValidator.validate();
        if (!lengthIsValid) {
            System.out.println("Error! Length has constraints [1, 10]");
            return;
        }

        System.out.println("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();
        scanner.close();
        ShapeTypeValidator shapeTypeValidator = new ShapeTypeValidator(shapeType);

        boolean shapeIsValid = shapeTypeValidator.validate();
        if (!shapeIsValid) {
            System.out.println("Error! Unknown shape.");
            return;
        }

        String shape = createShape(length, shapeType);
        System.out.println(shape);
    }

    private static String createShape(int length, int type) {
        String result = null;

        if (type == EquilateralShape.EQUILATERAL_TRIANGLE.getType()) {
            EquilateralShape.EQUILATERAL_TRIANGLE.setLength(length);
            result = EquilateralShape.EQUILATERAL_TRIANGLE.render();
        } else if (type == EquilateralShape.SQUARE.getType()) {
            EquilateralShape.SQUARE.setLength(length);
            result = EquilateralShape.SQUARE.render();
        }

        return result;
    }
}
