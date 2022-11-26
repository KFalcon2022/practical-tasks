package com.walking.lesson4_cycles;

import java.util.Scanner;

/**
 * Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа).
 * Нарисовать в консоли заданный прямоугольник, используя “-“ и “|”.
 * Углы прямоугольника обозначить символом “ “.
 * Каждая единица длины должна обозначаться одним символом “-“,
 * каждая единица ширины – символом “|“.
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rectangle's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter rectangle's width: ");
        int width = scanner.nextInt();

        scanner.close();
//        Формируем строку, обозначающую верхнюю и нижнюю грани
//        Примерный вид: " ----- "
        String horizontalLine = " ";

        for (int i = 0; i < length; i++) {
            horizontalLine += "-";
        }

        horizontalLine += " \n";

//        Формируем строку, обозначающую часть левой и правой граней.
//        Примерный вид: "|     |"
        String verticalLinesUnit = "|";

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += " ";
        }

        verticalLinesUnit += "|\n";


//        Формируем строку, обозначающую левую и правую грани целиком
//        Примерный вид: "|     |\n|     |\n|     |\n"

        String verticalLines = "";

        for (int i = 0; i < width; i++) {
            verticalLines += verticalLinesUnit;
        }

        System.out.println(horizontalLine + verticalLines + horizontalLine);
    }
    /*
     * Примечание: многие предложили другие решения. Какие-то из них содержали переменные,
     * какие-то - выводили фигуру посимвольно.
     * Эти решения также имеют право на жизнь, они тоже хороши.
     * Данное решение - лично мое видение
     * */
}
