package com.walking.lesson25_nested_classes.task1.static_class;

import com.walking.lesson25_nested_classes.task1.static_class.interfaces.RightShapeInterface;

import java.io.IOException;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя статические вложенные классы.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int chosenShapeNumber = selectShape();
        int chosenShapeSize = selectSize();
        createFigure(chosenShapeNumber,chosenShapeSize);
    }
    private static void createFigure(int shapeType, int sideSize) {
        switch (shapeType) {
            case (1) -> {
                new Triangle(sideSize).drawShape();
            }
            case (2) -> {
                new Square(sideSize).drawShape();
            }
            default -> System.out.println("Something wrong in program...");
        }
    }

    private static int selectShape() throws IOException {
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("Please, select shape to draw (only 1 or 2) and press enter");
        System.out.println("\n");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.print("\nYour choice: ");
        int choise = scannerIn.nextInt();
        if (choise != 1 && choise != 2) {
            System.out.println("You entered wrong number. Shape number " + choise + " doesn't exist!");
            throw new IOException();
        }
        return choise;
    }

    private static int selectSize() {
        Scanner scannerIn = new Scanner(System.in);
        System.out.print("Enter the size of the shape's side: ");
        int size = scannerIn.nextInt();
        scannerIn.close();
        return size;
    }
    private static class Square implements RightShapeInterface{
        private final int length;
        public Square(int length){
            this.length=length;
        }

        @Override
        public void drawShape() {
            System.out.println("\nDrawing square...");
            System.out.println(createShape());
        }

        @Override
        public String drawHorizontalLine() {
            String resultLine = "";
            for (int i = 0; i < length; i++) {
                resultLine += HORIZONTAL_LINE;
            }
            return resultLine + "\n";
        }

        @Override
        public String createShape() {
            String figureLines = "";
            figureLines += drawHorizontalLine();
            for (int i = 0; i < length; i++) {
                figureLines += drawVerticalLine();
            }
            figureLines += drawHorizontalLine();
            return figureLines;
        }
        private String drawVerticalLine() {
            String resultLine = "";
            resultLine += VERTICAL_LINE;
            for (int i = 1; i < length - 1; i++) {
                resultLine += EMPTY_CHAR;
            }
            resultLine += VERTICAL_LINE;
            return resultLine + "\n";
        }
    }
    private static class Triangle implements RightShapeInterface {
        private final int length;
        public Triangle (int length){
            this.length=length;
        }

        @Override
        public void drawShape() {
            System.out.println("\nDrawing triangle...");
            System.out.println(createShape());
        }

        @Override
        public String drawHorizontalLine() {
            String resultLine="";
            for (int i=0;i<length;i++){
                resultLine+=HORIZONTAL_LINE;
            }
            return resultLine + "\n";
        }

        @Override
        public String createShape() {
            String returnLine="";
            for (int i=0;i<length;i++){
                returnLine+=drawLine(i);
            }
            returnLine+=drawHorizontalLine();
            return returnLine+"\n";
        }
        private String drawLine(int index){
            String returnLine="";
            returnLine+=VERTICAL_LINE;
            for (int i=0;i<index;i++){
                returnLine+=EMPTY_CHAR;
            }
            returnLine+=SLASH_LINE_RIGTH;
            for (int i=index;i<=length;i++){
                returnLine+=EMPTY_CHAR;
            }
            return returnLine+"\n";
        }
    }
}
