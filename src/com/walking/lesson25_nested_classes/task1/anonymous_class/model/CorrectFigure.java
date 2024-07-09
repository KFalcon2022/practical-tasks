package com.walking.lesson25_nested_classes.task1.anonymous_class.model;

public interface CorrectFigure {
    static final String HORIZONTAL_LINE="-";
    static final String VERTICAL_LINE="|";
    static final String LEFT_LINE="/";
    static final String RIGHT_LINE="\\"; 
    static final String SPACE=" ";
    static final String NEW_LINE="\n";

    int getLength();

    String printFigure();    

    default String repeatString(String symbol, int times){
        String s="";
        for (int i=1; i<=times; i++){
            s+=symbol;
        }
        return s;
    }
}
