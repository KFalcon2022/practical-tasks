package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.model.CorrectFigure;
import com.walking.lesson14_polymorphism.task1.model.Square;
import com.walking.lesson14_polymorphism.task1.model.Triangle;

import java.util.Scanner;

/**
 * Реализуйте класс «Правильная фигура».
 * <P>
 * Для него создайте классы-наследники Треугольник и Квадрат.
 *
 * Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
 * <p>
 * Программа должна нарисовать в консоли выбранную пользователем фигуру, используя символы '-', '|', '/', '\'.
 * <p>
 * Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
 */
public class Main {
    private static final String MENU = """
            1. Square
            2. Triangle
            
            Made your choice: """;
    private static final String SIDE_LENGTH = "Enter a figure's side length: ";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createFigure();

    }

    public static final int requireInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static final void createFigure() {
        int figureNum = requireInt(MENU);

        if (figureNum == 1 || figureNum == 2) {
            int figureSide = requireInt(SIDE_LENGTH);

            scanner.close();
            switch (figureNum) {
                case 1:
                    CorrectFigure square = new Square(figureSide);
                    break;
                case 2:
                    CorrectFigure triangle = new Triangle(figureSide);
                    break;
                default:
                    System.out.println("Unknown figure");
            }
        }
        else {
            scanner.close();
            System.out.println("Unknown fig");
        }
    }
}
