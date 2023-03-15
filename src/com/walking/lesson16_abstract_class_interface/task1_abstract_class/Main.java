package com.walking.lesson16_abstract_class_interface.task1_abstract_class;

import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.EquilateralTriangle;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Square;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя абстрактный класс.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

//        Корректнее валидировать значение сразу после ввода. Здесь проверка вынесена после
//        ради демонстрации ситуации, когда скобки в условном выражении действительно необходимы
        if (length < 1 || (shapeType != 1 && shapeType != 2)) {
            System.out.println("Incorrect input.");
            return;
        }

        String shapeString = createShapeString(length, shapeType);
        System.out.println(shapeString);
    }

    private static String createShapeString(int length, int type) {


        switch (type) {
            case 1:
                return new Square(length).createShapeString();

            case 2:
                return new EquilateralTriangle(length).createShapeString();

            default:
                return "Unknown shape";
        }



    }
}
