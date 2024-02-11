package com.walking.lesson20_exceptions.task2.shapes;

public abstract class RightShape {
    protected static final String EMPTY_CHAR=" ";

    protected RightShape(){
    }
    public abstract void drawShape();

    protected String drawHorizontalLine(int sideSize, String horizontalLine){
        String resultLine="";
        for (int i=0;i<sideSize;i++) {
            resultLine += horizontalLine;
        }
        return resultLine+="\n";
    }
}
