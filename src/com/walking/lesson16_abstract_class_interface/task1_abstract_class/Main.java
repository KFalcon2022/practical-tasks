package com.walking.lesson16_abstract_class_interface.task1_abstract_class;


import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Figure;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Square;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Triangle;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя абстрактный класс.
 */
public class Main {
    public static void main(String[] args) {
        byte selectedFigure, selectedLength;

        Scanner io = new Scanner(System.in);

        System.out.println("What figure do you want? [1 - triangle, 2 - square]");
        selectedFigure = io.nextByte();
        System.out.println("Enter side's length [min - 3, max - 20]");
        selectedLength = io.nextByte();
        io.close();

//        Checking user's validity
        if (selectedFigure <1 || selectedFigure > 2 || selectedLength < 3 || selectedLength > 20){
            System.out.println("Invalid entry");
            return;
        }
        System.out.println("Entry is VALID. Drawing your figure...\n");

        Figure aa;

        if (selectedFigure == 1){
            aa = new Triangle(selectedLength);
        }
        else {
            aa = new Square(selectedLength);
        }

        System.out.println(aa.builtFigure());







    }
}
