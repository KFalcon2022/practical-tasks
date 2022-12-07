package com.walking.lesson20_exceptions.task2;

import com.walking.lesson20_exceptions.task2.model.EquilateralShape;
import com.walking.lesson20_exceptions.task2.model.EquilateralTriangle;
import com.walking.lesson20_exceptions.task2.model.InputValidationException;
import com.walking.lesson20_exceptions.task2.model.Square;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter shape's length: ");
            int length = scanner.nextInt();

            if (length < 1) {
                throw new InputValidationException("Length cannot be less than 1");
            }

            System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
            int shapeType = scanner.nextInt();

            scanner.close();

            if (shapeType != 1 && shapeType != 2) {
                throw new InputValidationException("Incorrectly entered number");
            }

            String shapeString = createShapeString(length, shapeType);
            System.out.println(shapeString);

        } catch (InputValidationException ex) {
            System.out.println(ex.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Invalid data type");
        }
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
