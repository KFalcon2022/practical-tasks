package com.walking.lesson17_enum.task3;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        EquilateralShape.length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();
        scanner.close();

        String shapeString = createShapeString(EquilateralShape.length, shapeType);
        System.out.println(shapeString);
    }
    private static String createShapeString(int length, int type) {

        switch (type) {
            case 1:
                return EquilateralShape.Square.createShapeString(length);

            case 2:
                return EquilateralShape.EquilateralTriangle.createShapeString(length);
        }
        return "Unknown shape";
    }


}
