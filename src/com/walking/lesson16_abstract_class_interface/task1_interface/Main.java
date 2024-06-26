package com.walking.lesson16_abstract_class_interface.task1_interface;

import java.util.Scanner;

import com.walking.lesson16_abstract_class_interface.task1_interface.model.CorrectFigure;
import com.walking.lesson16_abstract_class_interface.task1_interface.model.Square;
import com.walking.lesson16_abstract_class_interface.task1_interface.model.Triangle;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя интерфейс.
 */
public class Main {
    public static void main(String[] args) {
        CorrectFigure figure=null;
        System.out.print("Insert figure: 1-triangle, 2-square :");
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        System.out.print("Insert length:");
        switch (i) {
            case 1:
                figure=new Triangle(sc.nextInt()); 
                break;
            case 2:
                figure=new Square(sc.nextInt()); 
                break;        
            default:
                System.out.print("\nWrong figure");
                break;
        }
        sc.close();
        if (figure!=null)
        System.out.print(figure.printFigure());
    }
}
