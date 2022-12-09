package com.walking.lesson16_abstract_class_interface.task1;

import java.util.Scanner;

/*
Реализуйте класс «Правильная фигура». Для него создайте классы-наследники «Треугольник» и «Квадрат».
*/

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String M_SIZE  = "Figure size:";
    private static final String M_KIND  = "Figure kind (3 or 4):";
    private static final String M_AGAIN = "Repeat? (1=yes, other=no):";
    private static final String E_UNSUPPORTED = "Figure unsupported\n";

    public static void main(String[] args) {
        
        do {
            // Запросить фигуру у пользователя
            Drawable figure = askFigure();
            
            // Пусть фигура нарисует себя
            figure.draw();
            
        } while (askAgain());

        SCANNER.close();
    }

    // Этот метод должен вернуть фигуру
    private static Drawable askFigure(){
        int figureSize = 0;
        while (figureSize < 2){
            figureSize = inputInt(M_SIZE);
        }
        while (true) {
            int figureKind = inputInt(M_KIND);
            switch (figureKind) {
                case 3: return new Triangle(figureSize);
                case 4: return new Square(figureSize);
                default: say(E_UNSUPPORTED);
            }
        }
    }
    
    private static boolean askAgain(){
        return inputInt(M_AGAIN) == 1;
    }

    private static int inputInt(String msg) {
        say(msg);
        return SCANNER.nextInt();
    }

    private static void say(String msg) {
        System.out.print(msg);
    }
}