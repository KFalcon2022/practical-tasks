package com.walking.lesson26.Task1;
/**
 * Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа).
 * Нарисовать в консоли заданный прямоугольник, используя “-“ и “|”.
 * Углы прямоугольника обозначить символом “ “.
 * Каждая единица длины должна обозначаться одним символом “-“,
 * каждая единица ширины – символом “|“.
 */

public class Main {
    public static final java.util.Scanner SC = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter rectangle width and height (2x2 min)");
        int width = SC.nextInt(), height = SC.nextInt();
        SC.close();

        if (width > 1 && height > 1){
            System.out.println((new Rectangle(width, height)).asString());
        } else {
            System.out.println("Рисовать прямоугольник с указанными сторонами будет некрасиво.\nОбычное сообщение об ошибке, смысла в исключении не вижу.");
        }
    }

    // Мы занимаемся строками. Чтоб не городить огород, класс объявлен прямо в майне.
    // Можно было и отдельно. В качестве сборки выбрал StringBuilder
    // Не знаю для чего может понадобиться построение прямоугольника несколькими потоками.
    public static class Rectangle{
        private static final String SYM_H = "-";
        private static final String SYM_V = "|";
        private static final String SYM_C = " ";
        private static final String SYM_NL = "\n";

        private final int width;
        private final int height;
        private String stringRepresentation;

        public Rectangle (int width, int height){
            this.width = width;
            this.height = height;
            stringRepresentation = "";
        }

        private void concatHorizontalLine(StringBuilder sb) {
            sb.append(SYM_C);
            for (int i=2; i<width; i++) {sb.append(SYM_H);}
            sb.append(SYM_C);
            sb.append(SYM_NL);
        }

        private void concatMiddleLine(StringBuilder sb) {
            sb.append(SYM_V);
            for (int i=2; i<width; i++) {sb.append(SYM_C);}
            sb.append(SYM_V);
            sb.append(SYM_NL);
        }

        public String asString(){
            if (stringRepresentation.isEmpty()){
                StringBuilder SB = new StringBuilder();
                concatHorizontalLine(SB);
                for (int i=2; i<height; i++) {concatMiddleLine(SB);}
                concatHorizontalLine(SB);
                stringRepresentation = SB.toString();
            }
            return stringRepresentation;
        }
    }
}
