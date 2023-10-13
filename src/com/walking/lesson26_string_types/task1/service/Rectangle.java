package com.walking.lesson26_string_types.task1.service;

public class Rectangle {
    static final char HORIZONTAL_LINE='-';
    static final char VERTICAL_LINE='|';
    static final char EMPTY_CHAR=' ';
    static final char NEW_LINE_CHAR='\n';
    final int length;
    final int width;
    public Rectangle(int length, int width){
        this.length=length;
        this.width=width;
    }
    public StringBuilder createRectangle(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(createCornerLine());
        for (int i=1;i<length-1;i++){
                stringBuilder.append(createLine()).append(NEW_LINE_CHAR);
        }
        stringBuilder.append(createCornerLine());
        return stringBuilder;
    }
    private StringBuilder createCornerLine(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EMPTY_CHAR);
        for (int i=1;i<width-1;i++){
            stringBuilder.append(HORIZONTAL_LINE);
        }
        stringBuilder.append(EMPTY_CHAR).append(NEW_LINE_CHAR);
        return stringBuilder;
    }
    private StringBuilder createLine(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VERTICAL_LINE);
        for (int i=1;i<width-1;i++){
            stringBuilder.append(EMPTY_CHAR);
        }
        stringBuilder.append(VERTICAL_LINE).append(NEW_LINE_CHAR);
        return stringBuilder;
    }
}
