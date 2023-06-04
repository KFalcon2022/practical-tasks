package com.walking.lesson17_enum.task3;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();
        if (length < 1 ) {
            System.out.println("Incorrect length.");
            return;
        }
        System.out.print("Enter shape's type(Square/Triangle)\n");
        String shapeType = scanner.next();
        scanner.close();

//        Корректнее валидировать значение сразу после ввода. Здесь проверка вынесена после
//        ради демонстрации ситуации, когда скобки в условном выражении действительно необходимы


        try{
            System.out.println(Shapes.valueOf(shapeType).createShapeString(length));
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect shape " + shapeType);
        }

    }
}
