package com.walking.lesson20_exceptions.task2;


import com.walking.lesson20_exceptions.task2.model.Figure;
import com.walking.lesson20_exceptions.task2.model.InputValidationException;
import com.walking.lesson20_exceptions.task2.model.Square;
import com.walking.lesson20_exceptions.task2.model.Triangle;

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

        int sideLength;
        int choosedFigure;

        System.out.println("Введи длину стороны:");

        Scanner scanner = new Scanner(System.in);

        sideLength = scanner.nextInt();

        System.out.println("Что вывести?\n1. Квадрат\n2. Треугольник");

        choosedFigure = scanner.nextInt();

        Figure figure = null;

        if (choosedFigure == 1) {
            figure = new Square(sideLength);
        } else if (choosedFigure == 2) {
            figure = new Triangle(sideLength);
        } else {
            throw new InputValidationException("Ввод должен быть 1 или 2", choosedFigure);
        }

        scanner.close();

        System.out.println(figure.printFigure());
    }
}
