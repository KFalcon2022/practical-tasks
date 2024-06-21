package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public abstract class CorrectFigure {
    protected final String HORIZONTAL_LINE="-";
    protected final String VERTICAL_LINE="|";
    protected final String LEFT_LINE="/";
    protected final String RIGHT_LINE="\\"; 
    protected final String SPACE=" ";
    protected final String NEW_LINE="\n";

    private int length;

    protected CorrectFigure(int length){
        this.length=length;
    }

    protected int getLength(){
        return length;
    }

    public abstract String printFigure();    
}
