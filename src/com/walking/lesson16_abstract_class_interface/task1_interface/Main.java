package com.walking.lesson16_abstract_class_interface.task1_interface;


import com.walking.lesson16_abstract_class_interface.task1_interface.model.Figure;
import com.walking.lesson16_abstract_class_interface.task1_interface.model.Square;
import com.walking.lesson16_abstract_class_interface.task1_interface.model.Triangle;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя интерфейс.
 */
public class Main {
    public static void main(String[] args) {
        int selectedFigure, selectedLength;

        Scanner scanner = new Scanner(System.in);

        System.out.println("What figure do you want? [1 - triangle, 2 - square]");
        selectedFigure = scanner.nextInt();
        System.out.println("Enter side's length [min - 3, max - 20]");
        selectedLength = scanner.nextInt();
        scanner.close();

//        Checking user's validity
        if (selectedFigure <1 || selectedFigure > 2 || selectedLength < 3 || selectedLength > 20){
            System.out.println("Invalid entry");
            return;
        }
        System.out.println("Entry is VALID. Drawing your figure...\n");

        Figure figure;

        if (selectedFigure == 1) {
            figure = new Triangle();
        }
        else {
            figure = new Square();
        }
        System.out.println(figure.drawFigure(selectedLength));

    }
}
