package com.walking.lesson20_exceptions.task2;

/**
 * Реализуйте любой из вариантов Задачи 1 в уроке 16.
 * При некорректном вводе с клавиатуры выбрасывайте собственное исключение InputValidationException.
 * Не забудьте указать в описании, какой именно из вводов был некорректен -
 * message исключения должен быть информативным.
 * Предка исключения определите самостоятельно.
 */

import com.walking.lesson20_exceptions.task2.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();
        try {
            if (length < 1 || (shapeType != 1 && shapeType != 2)) {
                throw new InputValidationException("Incorrect input.");
            }

            String shapeString = createShapeString(length, shapeType);
            System.out.println(shapeString);
        } catch (InputValidationException inputValidationException) {
            System.out.println(inputValidationException.getMessage());
        }
    }

    private static String createShapeString(int length, int type) throws InputValidationException {
        EquilateralShape shape;

        switch (type) {
            case 1:
                shape = new Square(length);
                break;
            case 2:
                shape = new EquilateralTriangle(length);
                break;
            default:
                throw new InputValidationException("Unknown shape");
        }

        return shape.createShapeString();
    }
}
