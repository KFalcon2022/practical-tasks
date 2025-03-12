package com.walking.lesson14_polymorphism.task1;

import java.util.Scanner;

/**
 * ���������� ����� ����������� ������.
 * ��� ���� �������� ������-���������� ������������ � ��������.
 * <p>
 *  ������������ ������ ����� ����������� ������ ����� ������� � ������� ��� ������.
 *  ��������� ������ ���������� � ������� ��������� ������������� ������,
 *  ��������� ������� '-', '|', '/', '\'.
 * <p>
 * �������� ��������, ������ '\' � Java ���������� ������������: '\\'.
 */
    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("������� ��� ������: ");
            String figureType = in.nextLine();
            System.out.print("������� ����� �������: ");
            int length = in.nextInt();

            if (length < 1) {
                System.out.println("������������ ����");
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
