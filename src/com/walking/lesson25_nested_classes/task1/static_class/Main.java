package com.walking.lesson25_nested_classes.task1.static_class;

import com.walking.lesson25_nested_classes.task1.nested_class.EquilateralShape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя статические вложенные классы.
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

    private static String createShapeString(int length, int shapeType) {
        EquilateralShape equilateralShape;
        switch (shapeType){
            case 1:
                equilateralShape = new Square(length);
                break;
            case 2:
                equilateralShape = new Triangle(length);
                break;
            default:
                throw new RuntimeException("Unknown shape");
        }
        return equilateralShape.getStringShape();
    }

    private static class Square implements EquilateralShape{
        private final int length;

        public Square(int length){
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }

        @Override
        public String getStringShape() {
            String stringShape = "";
            for (int i = 0; i < length; i++) {
                stringShape += "-";
            }
            for (int j = 2; j < length; j++) {
                stringShape+="\n";
                stringShape+="|";
                for (int i = 2; i < length; i++) {
                    stringShape+=" ";
                }
                stringShape+="|";
            }
            stringShape+="\n";
            for (int i = 0; i < length; i++) {
                stringShape+="-";
            }
            stringShape+="\n";
            return stringShape;
        }
    }
    private static class Triangle implements EquilateralShape{
        private final int length;

        public Triangle(int length){
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }

        @Override
        public String getStringShape() {
            String stringShape = "";
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    stringShape += " ";
                }

                stringShape += "/";

                for (int j = 0; j < i * 2; j++) {
                    stringShape += " ";
                }

                stringShape += "\\" + "\n";
            }

            stringShape += " ";

            for (int i = 0; i < length; i++) {
                stringShape += "--";
            }
            return stringShape;
        }
    }
}
