package com.walking.lesson20_exceptions.task2;

import com.walking.lesson20_exceptions.task2.model.Figure;
import com.walking.lesson20_exceptions.task2.model.Square;
import com.walking.lesson20_exceptions.task2.model.Triangle;
import com.walking.lesson20_exceptions.task2.service.InputValidationException;

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
        Scanner io = new Scanner(System.in);

        System.out.println("Enter '1' for square, '2' for triangle");
        int userFigure = io.nextInt();
        if (userFigure != 1 && userFigure != 2) {
            throw new InputValidationException("You have chosen incorrect figure");
        }

        System.out.println("Enter figure width");
        int userWidth = io.nextInt();
        if (userWidth <= 2 || userWidth > 30) {
            throw new InputValidationException("Width must be 2 - 30");
        }

        io.close();

        Figure figure;
        if (userFigure == 1) {
            figure = new Square();
        } else {
            figure = new Triangle();
        }
        System.out.println(figure.buildFigure(userWidth));
    }
}
