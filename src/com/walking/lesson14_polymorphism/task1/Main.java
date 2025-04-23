package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.model.RegularFigure;
import com.walking.lesson14_polymorphism.task1.model.Square;
import com.walking.lesson14_polymorphism.task1.model.Triangle;

import java.util.Scanner;

/**
 * Реализуйте класс «Правильная фигура».
 * Для него создайте классы-наследники «Треугольник» и «Квадрат».
 * <p>
 * Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
 * Программа должна нарисовать в консоли выбранную пользователем фигуру,
 * используя символы '-', '|', '/', '\'.
 * <p>
 * Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
 */

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String MENU = """
            1. Triangle
            2. Square
            
            Make your choice: """;

    public static void main(String[] args) {
        int figureType = requireInt(MENU);

        int length = requireInt("Enter a length: ");

        System.out.println(createFigure(figureType, length));
    }

    private static String createFigure(int figureType, int length) {
        RegularFigure figure = null;

        switch (figureType) {
            case 1:
                figure = new Triangle(length);
                break;
            case 2:
                figure = new Square(length);
                break;
            default:
                figure = new RegularFigure(length);
        }
        return figure.print();
    }

    public static int requireInt(String message) {
        System.out.print(message);
        return SCANNER.nextInt();
    }
}
