package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.regularFigure.RegularFigure;
import com.walking.lesson14_polymorphism.task1.regularFigure.RegularTriangle;
import com.walking.lesson14_polymorphism.task1.regularFigure.Square;
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
    public static final String REQUIRING_MESSAGE_SIZE = "Enter figure`s size: ";
    public static final String REQUIRING_MESSAGE_FIGURE = "Enter required shape: ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = requireInt(scanner);
        String figure = requireString(scanner);

        scanner.close();

        RegularFigure regularFigure = createObjFigure(size, figure);

        regularFigure.printFigure();
    }

    private static RegularFigure createObjFigure(int size, String figure) {
        switch (figure) {
            case RegularTriangle.NAME_TRIANGLE:
                return new RegularTriangle(size);
            case Square.NAME_SQUARE:
                return new Square(size);
            default:
                return new RegularFigure(size);
        }
    }

    static int requireInt(Scanner scanner) {
        System.out.print(REQUIRING_MESSAGE_SIZE);

        return scanner.nextInt();
    }

    public static String requireString(Scanner scanner) {
        System.out.print(REQUIRING_MESSAGE_FIGURE);

        return scanner.next();
    }
}
