package com.walking.lesson26_string_types.task1;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson6_methods/Task3.java">...</a>
 * используя StringBuilder или StringBuffer. Объясните свой выбор.
 */

/**
 * Выбрал StringBuilder, так как задача не требует потокобезопасности
 * и StringBuilder тем самым работает быстрее StringBuffer.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length, width;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter length: ");
        length = in.nextInt();

        System.out.print("Enter width: ");
        width = in.nextInt();

        System.out.println(createResctangle(length,width));

        in.close();
    }

    public static StringBuilder createResctangle(int length, int width){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(createVerticalLine(length));
        stringBuilder.append(createHorizontalLine(length,width));
        stringBuilder.append(createVerticalLine(length));

        return stringBuilder;
    }
    public static StringBuilder createHorizontalLine(int length,int width){
        StringBuilder horizontalLine = new StringBuilder();

        for(int j = 0; j < width-2; j++){
            horizontalLine.append("|");
            for (int i = 0;i<length-2; i++)
            {
                horizontalLine.append(" ");
            }
            horizontalLine.append("|\n");
        }

        return horizontalLine;
    }

    public static StringBuilder createVerticalLine(int length){
        StringBuilder verticalLine = new StringBuilder();

        verticalLine.append(" ");
        for(int i = 1; i < length - 1; i++)
        {
            verticalLine.append('-');
        }
        verticalLine.append("\n");

        return verticalLine;
    }
}
