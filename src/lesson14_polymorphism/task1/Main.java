package lesson14_polymorphism.task1;

import java.util.Scanner;

public class Main {
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int shape = requireInt("Что рисуем? \n1 - треугольник\n2 - прямоугольник");
        int length = requireInt("Какой длины стороны?");

        input.close();

        switch (shape) {
            case 1:
                new Triangle(length).draw();
                break;
            case 2:
                new Square(length).draw();
                break;
            default:
                System.out.println("Много хотите :3");
        }
    }

    static int requireInt(String invite) {
        System.out.println(invite);
        return input.nextInt();
    }
}
