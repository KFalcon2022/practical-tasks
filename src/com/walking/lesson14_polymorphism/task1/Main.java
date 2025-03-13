package com.walking.lesson14_polymorphism.task1;

import java.util.Scanner;

/**
 * Реализуйте класс «Правильная фигура».
 * Для него создайте классы-наследники «Треугольник» и «Квадрат».
 * <p>
 *  Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
 *  Программа должна нарисовать в консоли выбранную пользователем фигуру,
 *  используя символы '-', '|', '/', '\'.
 * <p>
 * Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
 */
    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите тип фигуры: ");
            String figureType = in.nextLine();
            System.out.print("Введите длину стороны: ");
            int length = in.nextInt();

            if (length < 1) {
                System.out.println("Некорректный ввод");
                return;
            }

            RightFigure figure = new RightFigure(length);
            createShape(figure, figureType);

        }

        private static void createShape(RightFigure figure, String figureType) {
            switch (figureType.toLowerCase()) {
                case Triangle.NAME:
                    figure = new Triangle(figure.length);
                    figure.getTheFigure();
                    break;
                case Square.NAME:
                    figure = new Square(figure.length);
                    figure.getTheFigure();
                    break;
                default:
                    figure.getTheFigure();
            }
        }
    }
