package com.walking.lesson14_polymorphism.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // грубый, не отличающийся дружелюбностью, интерфейс
        System.out.println("Choose Shape type:");
        System.out.println("3 - triangle");
        System.out.println("4 - rectangle");

        Scanner scanner = new Scanner(System.in);
        Drawable figure;
        int figureType = scanner.nextInt();

        switch (figureType) {
            case 3: {
                figure = new RegularTriangle();
                break;
            }
            case 4: {
                figure = new RegularRectangle();
                break;
            }
            default: {
                System.out.println("Fuck you!");
                return;
            }
        }

        System.out.println("Enter figure size (>= " + RegularFigure.MINIMAL_DIMENSION + "):");
        int size = scanner.nextInt();
        scanner.close();

        // не будем заставлять пользователя вводить до победного
        if (size < RegularFigure.MINIMAL_DIMENSION) {
            System.out.println("Fuck you!");
            return;
        }

        System.out.println(figure.draw(size));
    }
}
