package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Square extends CorrectFigure implements IRepeater {

    public Square(int length) {
        super(length);
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
