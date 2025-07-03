package com.walking.lesson20_exceptions.task2;

import com.walking.lesson20_exceptions.task2.exception.InputValidationException;
import com.walking.lesson20_exceptions.task2.figure.RegularFigure;
import com.walking.lesson20_exceptions.task2.figure.Square;
import com.walking.lesson20_exceptions.task2.figure.Triangle;

import java.util.Scanner;

/**
 * Реализуйте любой из вариантов Задачи 1 в уроке 16.
 * При некорректном вводе с клавиатуры выбрасывайте собственное исключение InputValidationException.
 * Не забудьте указать в описании, какой именно из вводов был некорректен -
 * message исключения должен быть информативным.
 * Предка исключения определите самостоятельно.
 */
public class Main {
    public static void main(String[] args) throws InputValidationException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину стороны: ");
        int length = in.nextInt();

        if (length < 1) {
            throw new InputValidationException("Длина должна быть больше 0");
        }

        in = new Scanner(System.in); // не уверена, что это правильно, но без этой строки не даёт название фигуры ввести
        System.out.print("Введите тип фигуры: ");
        String figureType = in.nextLine();

        RegularFigure figure = switch (figureType.toLowerCase()) {
            case Triangle.NAME -> new Triangle(length);
            case Square.NAME -> new Square(length);
            default -> throw new InputValidationException("Неизвестный тип фигуры");
        };

        System.out.println(figure.getFigure());
    }
}
