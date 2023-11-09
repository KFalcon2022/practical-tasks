package com.walking.lesson25_nested_classes.task1.anonymous_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.model.EquilateralShape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
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
                shape = new EquilateralShape() {
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
                };
                break;
            case 2:
                shape = new EquilateralShape() {
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
                };
                break;
            default:
                return "Unknown shape";
        }

        return shape.getStringShape();
    }
}
