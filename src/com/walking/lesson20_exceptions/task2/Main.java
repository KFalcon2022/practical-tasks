package com.walking.lesson20_exceptions.task2;

import com.walking.lesson20_exceptions.task2.exceptions.InputValidationException;
import com.walking.lesson20_exceptions.task2.model.EquilateralShape;
import com.walking.lesson20_exceptions.task2.model.EquilateralTriangle;
import com.walking.lesson20_exceptions.task2.model.Square;

import java.util.Scanner;


/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя интерфейс.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        try {
            String shapeString = createShapeString(length, shapeType);
            System.out.println(shapeString);
        } catch (InputValidationException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String createShapeString(int length, int type) throws InputValidationException {
        EquilateralShape shape;
        if (length < 1){
            throw new InputValidationException("Incorrect length!: \nAllow value > 0");
        }

        switch (type) {
            case 1:
                shape = new Square(length);
                break;
            case 2:
                shape = new EquilateralTriangle(length);
                break;
            default:
                throw new InputValidationException("Incorrect type!: \nAllow value: 1 or 2");
        }

        return shape.createShapeString();
    }
}