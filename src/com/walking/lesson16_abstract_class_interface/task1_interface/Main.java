package com.walking.lesson16_abstract_class_interface.task1_interface;


import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.EquilateralShape;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.EquilateralTriangle;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Square;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя интерфейс.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length: ");
        int length = scanner.nextInt();
        System.out.print("Enter shape:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();
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
