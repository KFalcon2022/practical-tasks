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
            System.out.println(new Rectangle(width, height));
        } else {
            System.out.println("Не могу нарисовать такой маленький прямоугольник");
        }
    }

    // Мы занимаемся строками. Чтоб не городить огород, класс объявлен прямо в майне.
    // Можно было и отдельно. В качестве сборки выбрал StringBuilder
    // Не знаю для чего может понадобиться построение прямоугольника несколькими потоками.
    public static class Rectangle{
        private final int width;
        private final int height;
        private static final String SYM_H = "-";
        private static final String SYM_V = "|";
        private static final String SYM_C = " ";
        private static final String SYM_NL = "\n";
        private String stringRepresentation;

        public Rectangle (int width, int height){
            this.width = width;
            this.height = height;
            stringRepresentation = "";
        }

        private void concatTopBottom(StringBuilder sb) {
            sb.append(SYM_C);
            for (int i=2; i<width; i++) {sb.append(SYM_H);}
            sb.append(SYM_C);
            sb.append(SYM_NL);
        }

        private void concatMiddle(StringBuilder sb) {
            sb.append(SYM_V);
            for (int i=2; i<width; i++) {sb.append(SYM_C);}
            sb.append(SYM_V);
            sb.append(SYM_NL);
        }

        @Override
        public String toString(){
            if (stringRepresentation.isEmpty()){
                StringBuilder SB = new StringBuilder();
                concatTopBottom(SB);
                for (int i=2; i<height; i++) {concatMiddle(SB);}
                concatTopBottom(SB);
                stringRepresentation = SB.toString();
            }
            return stringRepresentation;
        }
    }
}
