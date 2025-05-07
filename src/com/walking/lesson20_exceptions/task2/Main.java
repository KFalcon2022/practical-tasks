package com.walking.lesson20_exceptions.task2;


import com.walking.lesson20_exceptions.task2.model.Figure;
import com.walking.lesson20_exceptions.task2.exception.InputValidationException;
import com.walking.lesson20_exceptions.task2.model.Square;
import com.walking.lesson20_exceptions.task2.model.Triangle;
import com.walking.lesson20_exceptions.task2.service.FigureService;

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
        FigureService figureService = new FigureService();

        System.out.println("Введи длину стороны:");
        Scanner scanner = new Scanner(System.in);
        int sideLength = scanner.nextInt();

        if (sideLength < 1) {
            throw new InputValidationException("Ввод должен быть 1 или более", sideLength);
        }

        System.out.println("Что вывести?\n1. Квадрат\n2. Треугольник");
        int choosedFigure = scanner.nextInt();
        scanner.close();

        Figure figure = figureService.getFigure(choosedFigure, sideLength);
        System.out.println(figure.printFigure());
    }
}
