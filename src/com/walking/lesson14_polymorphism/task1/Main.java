package com.walking.lesson14_polymorphism.task1;

import java.util.Scanner;

/*
Реализуйте класс «Правильная фигура». Для него создайте классы-наследники «Треугольник» и «Квадрат».
Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры. 
Программа должна нарисовать в консоли выбранную пользователем фигуру, используя символы '-', '|', '/', '\'.
Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
*/

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        
        int figureKind = inputInt("Figure kind (3 or 4):");
        int sideSize = inputInt("Figure size:");
        
        // Другой ввод не поддерживается. Можно конечно и ошибку выкинуть или просто сформировать Figure()
        Figure F = (figureKind == 3) ? new Triangle(sideSize) : new Square(sideSize);
        
        // Пусть фигура сама себя рисует
        F.draw();
    }

    static int inputInt(String msg) {
        System.out.print(msg);
        return SCANNER.nextInt();
    }

}
