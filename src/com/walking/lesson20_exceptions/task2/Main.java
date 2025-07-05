package com.walking.lesson20_exceptions.task2;

import com.walking.lesson20_exceptions.task2.model.EquilateralShape;
import com.walking.lesson20_exceptions.task2.model.EquilateralTriangle;
import com.walking.lesson20_exceptions.task2.model.Square;

import java.util.Scanner;

/**
 * Реализуйте любой из вариантов Задачи 1 в уроке 16.
 * При некорректном вводе с клавиатуры выбрасывайте собственное исключение InputValidationException.
 * Не забудьте указать в описании, какой именно из вводов был некорректен -
 * message исключения должен быть информативным.
 * Предка исключения определите самостоятельно.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            System.out.print("Enter shape's length: ");
            int length = scanner.nextInt();

            if (length < 1) {
                throw new InvalidValidationException("Length can't be less than 1!");
            }

            System.out.println("Enter shape's type:\n 1: Square\n 2: Triangle\n");
            int shapeType = scanner.nextInt();

            String shapeString = createShapeString(length, shapeType);
            System.out.println(shapeString);
    }

    private static String createShapeString(int length, int type) {
        // почему если здесь не указывать throws, код все равно работает корректно???

        if (length < 1) {
            throw new InvalidValidationException("Length can't be less than 1");
        }

        EquilateralShape shape;

        switch (type) {
            case 1:
                shape = new Square(length);
                break;
            case 2:
                shape = new EquilateralTriangle(length);
                break;
            default:
                throw new InvalidValidationException("Unknown shape type");
        }

        return shape.createShapeString();
    }
}
