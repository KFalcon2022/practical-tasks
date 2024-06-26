package com.walking.lesson14_polymorphism.task1.model;

public class CorrectFigure {
    final String HORIZONTAL_LINE="-";
    final String VERTICAL_LINE="|";
    final String LEFT_LINE="/";
    final String RIGHT_LINE="\\"; 
    final String SPACE=" ";

    public void printFigure(){
        System.out.println("Inserted wrong figure");
    }

    protected String repeater(String symbol, int times){
        String s="";
        for (int i=1; i<=times; i++){
            s+=symbol;
        }
        return s;
    }
    protected void log(String message){
        System.out.println(message);
    }
}
