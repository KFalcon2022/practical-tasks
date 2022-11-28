package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.shapes.Shape;
import com.walking.lesson14_polymorphism.task1.shapes.Square;
import com.walking.lesson14_polymorphism.task1.shapes.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип фигуры:\n1: Треугольник\n2: Квадрат");
        int type = scanner.nextInt();
        System.out.println("Введите длину сторон фигуры:");
        int length = scanner.nextInt();
        scanner.close();

        Shape shape = createShape(type, length);
        System.out.println(shape);
    }

    static Shape createShape (int type, int length) {
        return switch (type) {
            case 1 -> new Triangle(length);
            case 2 -> new Square(length);
            default -> null;
        };
    }
}
