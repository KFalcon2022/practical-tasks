package com.walking.lesson25_nested_classes.task1.static_class.model;

public class CorrectFigure {
    static final String HORIZONTAL_LINE="-";
    static final String VERTICAL_LINE="|";
    static final String LEFT_LINE="/";
    static final String RIGHT_LINE="\\"; 
    static final String SPACE=" ";
    static final String NEW_LINE="\n";

    static public String printFigure(int type, int length){
        if (type==1){
            return Triangle.printFigure(length);
        } 
        if (type==2){
            return Square.printFigure(length);
        }
        return "Empty";
    }    

    static String repeatString(String symbol, int times){
        String s="";
        for (int i=1; i<=times; i++){
            s+=symbol;
        }
        return s;
    }

    static class Triangle{
        static public String printFigure(int length) {
            String triangle="";
            for (int i=1; i<=length; i++){
                if (i==1){
                    triangle+=repeatString(SPACE, length-i)+LEFT_LINE+RIGHT_LINE+NEW_LINE;
                } else if(i==length) {
                    triangle+=LEFT_LINE+repeatString(SPACE, (i-1)*2)+RIGHT_LINE+NEW_LINE;
                    triangle+=repeatString(HORIZONTAL_LINE, length*2)+NEW_LINE;
                } else {
                    triangle+=repeatString(SPACE, length-i)+LEFT_LINE+repeatString(SPACE, (i-1)*2)+RIGHT_LINE+NEW_LINE;
                }
            }
            return triangle;
        }
    }

    static class Square{
        static public String printFigure(int length) {
            String square="";
            for (int i=1; i<=length; i++){
                if (i==1){
                    square+=SPACE+repeatString(HORIZONTAL_LINE, length*2)+NEW_LINE;
                    square+=VERTICAL_LINE+repeatString(SPACE, length*2)+VERTICAL_LINE+NEW_LINE;
                } else if (i==length){
                    square+=VERTICAL_LINE+repeatString(SPACE, length*2)+VERTICAL_LINE+NEW_LINE;
                    square+=SPACE+repeatString(HORIZONTAL_LINE, length*2)+NEW_LINE;
                } else {
                    square+=VERTICAL_LINE+repeatString(SPACE, length*2)+VERTICAL_LINE+NEW_LINE;
                }
            }
            return square;
        }
    }
}
