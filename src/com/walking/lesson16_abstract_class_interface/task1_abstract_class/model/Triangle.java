package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

public class Triangle extends CorrectFigure {

    public Triangle(int length) {
        super(length);
        //TODO Auto-generated constructor stub
    }

    @Override
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
