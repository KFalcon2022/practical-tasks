package com.walking.lesson20_exceptions.task2;

import com.walking.lesson20_exceptions.task2.model.EquilateralShape;
import com.walking.lesson20_exceptions.task2.model.EquilateralTriangle;
import com.walking.lesson20_exceptions.task2.model.Square;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя абстрактный класс.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину фигуры: ");
        int length = scanner.nextInt();
        if(length < 1)
        {
            throw new InputValidationException("Некорректный ввод длины фигуры");
        }

        System.out.print("Введите номер фигуры:\n 1: Квадрат\n 2: Правильный треугольник\n");
        int shapeType = scanner.nextInt();

        if(shapeType < 1 || shapeType > 2)
        {
            throw new InputValidationException("Неправильный ввод типа фигуры");
        }

        scanner.close();

        String shapeString = createShapeString(length, shapeType);

        System.out.println(shapeString);
    }
    private static String createShapeString(int length, int type) {
        EquilateralShape shape;
        switch (type) {
            case 1:
                shape = new Square(length);
                break;
            case 2:
                shape = new EquilateralTriangle(length);
                break;
            default:
                return "Unknown shape";
        }

        return shape.getStringShape();
    }
}
