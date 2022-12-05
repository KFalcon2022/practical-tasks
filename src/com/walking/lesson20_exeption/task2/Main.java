package com.walking.lesson20_exeption.task2;

import com.walking.lesson20_exeption.task2.model.InputValidationException;
import com.walking.lesson20_exeption.task2.model.EquilateralShape;
import com.walking.lesson20_exeption.task2.model.EquilateralTriangle;
import com.walking.lesson20_exeption.task2.model.Square;

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
        int length=0;
        int shapeType=0;


        do {
            try {
                System.out.print("Enter shape's length: ");
                length = scanner.nextInt();
                if (length < 1)
                    throw new InputValidationException("Длинна не может быть меньше 1!! А Вы ввели:", length);
            } catch (InputValidationException ex) {
                System.out.print(ex.getMessage());
                System.out.println(ex.getLength());
            } catch (Exception e) {
                System.out.println("Не пойму что случилось - вот такая вот ошибка:" + e);
                scanner.next();
            }
        }
        while (length < 1);

        do {
            try {
                System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
                shapeType = scanner.nextInt();
                if (shapeType < 1 ^ shapeType > 2)
                    throw new InputValidationException("Надо выбрать (1) Квадрат или (2) Треугольник!! А Вы выбрали:", shapeType);
            } catch (InputValidationException ex) {
                System.out.print(ex.getMessage());
                System.out.println(ex.getLength());
            }
        }
        while (shapeType < 1 ^ shapeType > 2);

        scanner.close();

//        Корректнее валидировать значение сразу после ввода. Здесь проверка вынесена после
//        ради демонстрации ситуации, когда скобки в условном выражении действительно необходимы
/*        if (length < 1 || (shapeType != 1 && shapeType != 2)) {  //Потеряло смысл
            System.out.println("Incorrect input.");
            return;
        }*/

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

        return shape.createShapeString();
    }
}
