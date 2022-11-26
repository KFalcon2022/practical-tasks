package lesson14;

import lesson14.task1RightFigure.Task1Triangle;
import lesson14.task1RightFigure.Task1Square;

import java.util.Scanner;

public class Task1Main {
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
            Task1Triangle triangle = new Task1Triangle(length);
            triangle.draw();
        }
        else if (figureChoice == 2) {
            Task1Square square = new Task1Square(length);
            square.draw();
        }
    }
}
