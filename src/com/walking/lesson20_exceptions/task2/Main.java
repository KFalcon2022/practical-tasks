package com.walking.lesson20_exceptions.task2;

import com.walking.lesson20_exceptions.task2.exceptions.InputValidationException;
import com.walking.lesson20_exceptions.task2.model.EquilateralTriangle;
import com.walking.lesson20_exceptions.task2.model.Shape;
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

    public static final int LENGTH_MIN = 1;
    public static final int LENGTH_MAX = 10;
    public static final int SHAPE_SQUARE = 1;
    public static final int SHAPE_EQUILATERAL_TRIANGLE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter shape's length: ");
        int length = scanner.nextInt();
        validateLength(length);

        System.out.printf("Enter shape's type:\n %d: Square\n %d: Triangle\n%n", SHAPE_SQUARE, SHAPE_EQUILATERAL_TRIANGLE);
        int shapeType = scanner.nextInt();
        scanner.close();
        validateShape(shapeType);

        Shape shape = createShape(length, shapeType);
        System.out.println(shape.render());
    }

    private static void validateLength(int length) {
        if (!(LENGTH_MIN < length && length < LENGTH_MAX)) {
            throw new InputValidationException(String.format("Length has constraints [%d, %d]", LENGTH_MIN, LENGTH_MAX));
        }
    }

    private static void validateShape(int type) {
        if (!(type == SHAPE_SQUARE || type == SHAPE_EQUILATERAL_TRIANGLE)) {
            throw new InputValidationException("Unsupported shape type");
        }
    }

    private static Shape createShape(int length, int type) {
        switch (type) {
            case SHAPE_SQUARE:
                return new  Square(length);
            case SHAPE_EQUILATERAL_TRIANGLE:
                return new EquilateralTriangle(length);
            default:
                throw new InputValidationException("Unsupported shape type");
        }
    }
}
