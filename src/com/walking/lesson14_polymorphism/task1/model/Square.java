package com.walking.lesson14_polymorphism.task1.model;

public class Square extends CorrectFigure {

    private int length;

    public Square(int length){
        this.length=length;
    }

    @Override
    public void printFigure(){
        printSquare();
    }

    private void printSquare(){
        for (int i=1; i<=length; i++){
            if (i==1){
                log(SPACE+repeater(HORIZONTAL_LINE, length*2));
                log(VERTICAL_LINE+repeater(SPACE, length*2)+VERTICAL_LINE);
            } else if (i==length){
                log(VERTICAL_LINE+repeater(SPACE, length*2)+VERTICAL_LINE);
                log(SPACE+repeater(HORIZONTAL_LINE, length*2));
            } else {
                log(VERTICAL_LINE+repeater(SPACE, length*2)+VERTICAL_LINE);
            }
        }
    }
   
}
