package com.walking.lesson25_nested_classes.task1.nested_class.model;

public class CorrectFigure {
    static final String HORIZONTAL_LINE="-";
    static final String VERTICAL_LINE="|";
    static final String LEFT_LINE="/";
    static final String RIGHT_LINE="\\"; 
    static final String SPACE=" ";
    static final String NEW_LINE="\n";

    private int length;
    private int type;

    public CorrectFigure(int type, int length){
        this.type=type;
        this.length=length;
    }

    public int getLength(){
        return length;
    }

    public String printFigure(){
        if (type==1){
            Triangle triangle=new Triangle();
            return triangle.printFigure();
        } 
        if (type==2){
            Square square=new Square();
            return square.printFigure();
        }
        return "Empty";
    }    

    private String repeatString(String symbol, int times){
        String s="";
        for (int i=1; i<=times; i++){
            s+=symbol;
        }
        return s;
    }

    class Triangle{
        public String printFigure() {
            String triangle="";
            for (int i=1; i<=getLength(); i++){
                if (i==1){
                    triangle+=repeatString(SPACE, getLength()-i)+LEFT_LINE+RIGHT_LINE+NEW_LINE;
                } else if(i==getLength()) {
                    triangle+=LEFT_LINE+repeatString(SPACE, (i-1)*2)+RIGHT_LINE+NEW_LINE;
                    triangle+=repeatString(HORIZONTAL_LINE, getLength()*2)+NEW_LINE;
                } else {
                    triangle+=repeatString(SPACE, getLength()-i)+LEFT_LINE+repeatString(SPACE, (i-1)*2)+RIGHT_LINE+NEW_LINE;
                }
            }
            return triangle;
        }
    }

    class Square{
        public String printFigure() {
            String square="";
            for (int i=1; i<=getLength(); i++){
                if (i==1){
                    square+=SPACE+repeatString(HORIZONTAL_LINE, getLength()*2)+NEW_LINE;
                    square+=VERTICAL_LINE+repeatString(SPACE, getLength()*2)+VERTICAL_LINE+NEW_LINE;
                } else if (i==getLength()){
                    square+=VERTICAL_LINE+repeatString(SPACE, getLength()*2)+VERTICAL_LINE+NEW_LINE;
                    square+=SPACE+repeatString(HORIZONTAL_LINE, getLength()*2)+NEW_LINE;
                } else {
                    square+=VERTICAL_LINE+repeatString(SPACE, getLength()*2)+VERTICAL_LINE+NEW_LINE;
                }
            }
            return square;
        }
    }
}
