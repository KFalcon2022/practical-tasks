package com.walking.lesson14_polymorphism.task1.model;

public class Triangle extends CorrectFigure {
    private int length;

    public Triangle(int length){
        this.length=length;
    }

    @Override
    public void printFigure(){
        printTriangle();
    }

    private void printTriangle(){
        for (int i=1; i<=length; i++){
            if (i==1){
                log(repeater(SPACE, length-i)+LEFT_LINE+RIGHT_LINE);
            } else if(i==length) {
                log(LEFT_LINE+repeater(SPACE, (i-1)*2)+RIGHT_LINE);
                log(repeater(HORIZONTAL_LINE, length*2));
            } else {
                log(repeater(SPACE, length-i)+LEFT_LINE+repeater(SPACE, (i-1)*2)+RIGHT_LINE);
            }
        }
    }
}
