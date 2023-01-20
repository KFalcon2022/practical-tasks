package com.walking.lesson16_abstract_class_interface.task1_abstract_class;

import com.walking.lesson16_abstract_class_interface.task1_abstract_class.helpers.View;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.*;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.validators.LengthValidator;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.validators.ShapeTypeValidator;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя абстрактный класс.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            View.show("Enter shape's length: ");
            int length = scanner.nextInt();
            LengthValidator lengthValidator = new LengthValidator(length);

            View.show("Enter shape's type:\n 1: Square\n 2: Triangle\n");
            int shapeType = scanner.nextInt();
            scanner.close();
            ShapeTypeValidator shapeTypeValidator = new ShapeTypeValidator(shapeType);

            Shape shape = createShape(length, shapeType);
            View.show(shape.preRender());
        } catch (Throwable exThrowable) {
            View.show(exThrowable.getMessage());
        }
    }

    private static Shape createShape(int length, int type) throws Exception {
        Shape shape;

        switch (type) {
            case Square.SHAPE_INDEX:
                shape = new Square(length);
                break;
            case EquilateralTriangle.SHAPE_INDEX:
                shape = new EquilateralTriangle(length);
                break;
            default:
                throw new Exception("Unknown shape");
        }

        return shape;
    }
}
