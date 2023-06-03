package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.model.RegularPolygon;
import com.walking.lesson14_polymorphism.task1.model.RegularTriangle;
import com.walking.lesson14_polymorphism.task1.model.Square;

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter polygon type");
        System.out.println("Enter 1 (square) or 2 (triangle)");
        int type = scanner.nextInt();

        System.out.println("Enter side length: ");
        int sideLength = scanner.nextInt();

        scanner.close();

        chooseFigure(type, sideLength);
    }

    public static void chooseFigure(int type, int sideLength) {
        if (type == 1 && sideLength > 0) {
            Square square = new Square(sideLength);
            printFigure(square);
        } else if (type == 2 && sideLength > 0) {
            RegularTriangle triangle = new RegularTriangle(sideLength);
            printFigure(triangle);
        } else System.out.println("Unknown figure or incorrect side length");
    }

    public static void printFigure(RegularPolygon polygon) {
        System.out.println(polygon.draw());
    }
}
