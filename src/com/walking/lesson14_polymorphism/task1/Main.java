package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.model.CorrectFigure;
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
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int sideLength = inputSideLength(SCANNER);
        int typeFigure = inputFigureType(SCANNER);
        SCANNER.close();

        CorrectFigure figure = null;
        switch (typeFigure) {
            case 1 -> figure = new Square();
            case 2 -> figure = new Triangle();
            default -> figure = new CorrectFigure();
        }
        figure.drawFigure(sideLength);
    }

    private static int inputSideLength(Scanner scanner) {
        System.out.println("Введите длину стороны:");
        return scanner.nextInt();
    }

    private static int inputFigureType(Scanner scanner) {
        System.out.println("Введите тип фигуры (1 - квадрат, 2 - треугольник)");
        return scanner.nextInt();
    }
}
