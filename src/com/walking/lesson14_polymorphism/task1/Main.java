package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.shapesAbstract.Shape;
import com.walking.lesson14_polymorphism.task1.shapesAbstract.Square;
import com.walking.lesson14_polymorphism.task1.shapesAbstract.Triangle;
import com.walking.lesson14_polymorphism.task1.shapesInterfaces.ShapeInterface;
import com.walking.lesson14_polymorphism.task1.shapesInterfaces.SquareImpl;
import com.walking.lesson14_polymorphism.task1.shapesInterfaces.TriangleImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип фигуры:\n1: Треугольник\n2: Квадрат");
        int type = scanner.nextInt();
        System.out.println("Введите длину сторон фигуры:");
        int length = scanner.nextInt();
        scanner.close();
        // ShapeAbstract
        Shape shape = createShape(type, length);
        System.out.println(shape);
        //ShapeInterfaces
        /*ShapeInterface shapeInterface = createShape(type,length);*/

    }

    static Shape createShape (int type, int length) {
        return switch (type) {
            case 1 -> new Triangle(length);
            case 2 -> new Square(length);
            default -> null;
        };
    }

   /* static ShapeInterface createShape (int type, int length) {
        return switch (type) {
            case 1 -> new TriangleImpl(length);
            case 2 -> new SquareImpl(length);
            default -> null;
        };
    }*/

}
