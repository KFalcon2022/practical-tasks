package com.walking.lesson14_polymorphism.task1;

import java.util.Scanner;

import com.walking.lesson14_polymorphism.task1.model.CorrectFigure;
import com.walking.lesson14_polymorphism.task1.model.Square;
import com.walking.lesson14_polymorphism.task1.model.Triangle;



/**
 * Реализуйте класс «Правильная фигура».
 * Для него создайте классы-наследники «Треугольник» и «Квадрат».
 * <p>
 * Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
 * Программа должна нарисовать в консоли выбранную пользователем фигуру,
 * используя символы '-', '|', '/', '\'.
 * <p>
 * Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
 */
public class Main {
    public static void main(String[] args) {
                CorrectFigure figure=new CorrectFigure();
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
                System.out.print("\n");
                break;
        }
        sc.close();
        figure.printFigure();
    }
}
