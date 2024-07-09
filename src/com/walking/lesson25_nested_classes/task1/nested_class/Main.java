package com.walking.lesson25_nested_classes.task1.nested_class;

import java.util.Scanner;

import com.walking.lesson25_nested_classes.task1.nested_class.model.CorrectFigure;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя внутренние классы.
 */
public class Main {
    public static void main(String[] args) {
                Integer type;
        Integer length;
        Scanner sc=new Scanner(System.in);

        System.out.println("Insert figure: 1-triangle, 2-square :");
        type=sc.nextInt();
        System.out.println("Insert length");
        length=sc.nextInt();
        sc.close();

        System.out.println(printFigure(type, length));
    }
    private static String printFigure(Integer type, Integer length) {
       CorrectFigure figure=new CorrectFigure(type, length);
       return figure.printFigure();
    }
}
