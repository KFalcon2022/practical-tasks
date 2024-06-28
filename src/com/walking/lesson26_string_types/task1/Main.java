package com.walking.lesson26_string_types.task1;

import java.util.Scanner;

import com.walking.lesson26_string_types.task1.model.Rectangle;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson6_methods/Task3.java">...</a>
 * используя StringBuilder или StringBuffer. Объясните свой выбор.
 */
/**
 * Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа).
 * Нарисовать в консоли заданный прямоугольник, используя “-“ и “|”.
 * Углы прямоугольника обозначить символом “ “.
 * Каждая единица длины должна обозначаться одним символом “-“,
 * каждая единица ширины – символом “|“.
 * <p>
 * Произвести декомпозицию по своему усмотрению. Рекомендую скинуть на проверку. Контакт ниже.
 */

 /*
  * StringBuilder используется потому, что не используется многопоточность. 
  * Лучше String в этом случае тем, что не забивает string pool лишними записями
  */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите длину прямоугольника:");
        int a=sc.nextInt();
        System.out.print("Введите ширину прямоугольника:");
        int b=sc.nextInt();
        sc.close();

        Rectangle rect=new Rectangle(a, b);
        System.out.println(rect.getImage());
    }
}
