package com.walking.lesson20_exceptions.task2;

import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.CorrectFigure;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Square;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Triangle;
import com.walking.lesson20_exceptions.task2.exceptions.InputValidationException;

import java.util.Scanner;

/**
 * Реализуйте любой из вариантов Задачи 1 в уроке 16.
 * При некорректном вводе с клавиатуры выбрасывайте собственное исключение InputValidationException.
 * Не забудьте указать в описании, какой именно из вводов был некорректен -
 * message исключения должен быть информативным.
 * Предка исключения определите самостоятельно.
 */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int sideLength = inputSideLength();
        int typeFigure = inputFigureType();

        SCANNER.close();

        createShape(sideLength, typeFigure);
    }

    private static void createShape(int length, int type) {
        CorrectFigure figure = null;
        switch (type) {
            case 1 -> figure = new Square(length);
            case 2 -> figure = new Triangle(length);
            default -> System.out.println("incorrect input");
        }

        if (figure != null) {
            figure.drawFigure(length);
        }
    }

    private static int inputSideLength() throws InputValidationException {
        System.out.println("Введите длину стороны:");
        int sideLength = SCANNER.nextInt();
        if (sideLength > 1) {
            return sideLength;
        } else throw new InputValidationException("Длина стороны не может быть меньше 1!");
    }

    private static int inputFigureType() throws InputValidationException {
        System.out.println("Введите тип фигуры (1 - квадрат, 2 - треугольник)");
        int type = SCANNER.nextInt();
        if (type == 1 || type == 2) {
            return type;
        } else throw new InputValidationException("Неверный тип фигуры, попробуйте снова.");
    }
}
