package com.walking.lesson25_nested_classes.task1.static_class;

import java.util.Scanner;

import com.walking.lesson25_nested_classes.task1.static_class.model.CorrectFigure;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя статические вложенные классы.
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

        System.out.println(CorrectFigure.printFigure(type, length));
    }
}
