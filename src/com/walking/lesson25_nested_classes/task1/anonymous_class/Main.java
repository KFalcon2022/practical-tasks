package com.walking.lesson25_nested_classes.task1.anonymous_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.service.interfaces.RightShapeInterface;

import java.io.IOException;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int chosenShapeNumber=selectShape();
        int chosenShapeSize=selectSize();
        createFigure(chosenShapeNumber,chosenShapeSize);
    }
    private static void createFigure(int shapeType, int sideSize){
        switch (shapeType) {
            case (1) -> {
                RightShapeInterface triangleShape = new RightShapeInterface() {
                    @Override
                    public void drawShape() {
                        System.out.println("\nDrawing triangle...");
                        System.out.println(createShape(sideSize));
                    }

                    @Override
                    public String drawHorizontalLine(int sideSize, String horizontalLine) {
                        String resultLine = "";
                        for (int i = 0; i < sideSize; i++) {
                            resultLine += horizontalLine;
                        }
                        return resultLine += "\n";
                    }

                    @Override
                    public String createShape(int sideSize) {
                        String returnLine = "";
                        for (int i = 0; i < sideSize; i++) {
                            returnLine += drawLine(i, sideSize);
                        }
                        returnLine += drawHorizontalLine(sideSize, HORIZONTAL_LINE);
                        return returnLine += "\n";
                    }

                    @Override
                    public String drawVerticalLine() {
                        return null;
                    }

                    @Override
                    public String drawLine(int index, int sideSize) {
                        String returnLine = "";
                        returnLine += VERTICAL_LINE;
                        for (int i = 0; i < index; i++) {
                            returnLine += EMPTY_CHAR;
                        }
                        returnLine += SLASH_LINE_RIGTH;
                        for (int i = index; i <= sideSize; i++) {
                            returnLine += EMPTY_CHAR;
                        }
                        return returnLine += "\n";
                    }
                };
                triangleShape.drawShape();
            }
            case (2) -> {
                RightShapeInterface squareShape = new RightShapeInterface() {
                    @Override
                    public void drawShape() {
                        System.out.println("\nDrawing square...");
                        System.out.println(createShape(sideSize));
                    }

                    @Override
                    public String drawHorizontalLine(int sideSize, String horizontalLine) {
                        String resultLine="";
                        for (int i=0;i<sideSize;i++){
                            resultLine+=horizontalLine;
                        }
                        return resultLine+="\n";
                    }

                    @Override
                    public String createShape(int sideSize) {
                        String figureLines="";
                        figureLines+= drawHorizontalLine(sideSize,HORIZONTAL_LINE);
                        for (int i=0;i<sideSize;i++){
                            figureLines+= drawVerticalLine();
                        }
                        figureLines+= drawHorizontalLine(sideSize,HORIZONTAL_LINE);
                        return figureLines;
                    }

                    @Override
                    public String drawVerticalLine() {
                        String resultLine="";
                        resultLine+=VERTICAL_LINE;
                        for (int i=1;i<sideSize-1;i++){
                            resultLine+=EMPTY_CHAR;
                        }
                        resultLine+=VERTICAL_LINE;
                        return resultLine+="\n";
                    }

                    @Override
                    public String drawLine(int index, int sideSize) {
                        return null;
                    }
                };
                squareShape.drawShape();
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
        int choise=scannerIn.nextInt();
        if (choise!=1&&choise!=2) {
            System.out.println("You entered wrong number. Shape number "+choise+" doesn't exist!");
            throw new IOException();
        }
        return choise;
    }

    private static int selectSize(){
        Scanner scannerIn=new Scanner(System.in);
        System.out.print("Enter the size of the shape's side: ");
        int size = scannerIn.nextInt();
        scannerIn.close();
        return size;
    }
}
