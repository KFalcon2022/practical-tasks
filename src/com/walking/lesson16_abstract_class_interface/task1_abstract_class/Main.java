package com.walking.lesson16_abstract_class_interface.task1_abstract_class;

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
        System.out.println("Enter shape's length: ");
        int length = scanner.nextInt();
        LengthValidator lengthValidator = new LengthValidator(length);

        boolean lengthIsValid = lengthValidator.validate();
        if (!lengthIsValid) {
            System.out.println("Error! Length has constraints [1, 10]");
            return;
        }

        System.out.println("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();
        scanner.close();
        ShapeTypeValidator shapeTypeValidator = new ShapeTypeValidator(shapeType);

        boolean shapeIsValid = shapeTypeValidator.validate();
        if (!shapeIsValid) {
            System.out.println("Error! Unknown shape.");
            return;
        }

        Shape shape = createShape(length, shapeType);
        System.out.println(shape.render());
    }

    private static Shape createShape(int length, int type){
        Shape shape = null;

        switch (type) {
            case Square.SHAPE_INDEX:
                shape = new Square(length);
                break;
            case EquilateralTriangle.SHAPE_INDEX:
                shape = new EquilateralTriangle(length);
                break;
        }

        return shape;
    }
}
