package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

public class Square extends CorrectFigure {

    public Square(int length) {
        super(length);
        //TODO Auto-generated constructor stub
    }

    @Override
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
