package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.model.Triangle;
import com.walking.lesson14_polymorphism.task1.model.Square;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int figureChoice = 1;
        int length = 1;
        boolean validEntry = false;

        while (!validEntry) {
            System.out.println("Choose figure to draw:\n1. Triangle\n2. Square");
            figureChoice = scanner.nextInt();
            if (figureChoice == 1 || figureChoice == 2) validEntry = true;
            else {
                System.out.println("Please, enter correct option.");
            }
        }
        validEntry = false;

        while (!validEntry) {
            System.out.print("Enter strictly positive length of figure: ");
            length = scanner.nextInt();
            if (length > 0) validEntry = true;
        }

        if (figureChoice == 1) {
            Triangle triangle = new Triangle(length);
            triangle.draw();
        }
        else if (figureChoice == 2) {
            Square square = new Square(length);
            square.draw();
        }
    }
}
