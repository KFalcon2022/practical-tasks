package com.walking.lesson17_enum.task3;

public enum CorrectFigure {
    Triangle{

        @Override
        public String printFigure(int length) {
            String triangle="";
            for (int i=1; i<=length; i++){
                if (i==1){
                    triangle+=repeatString(SPACE, length-i)+LEFT_LINE+RIGHT_LINE+NEW_LINE;
                } else if(i==length) {
                    triangle+=LEFT_LINE+repeatString(SPACE, (i-1)*2)+RIGHT_LINE+NEW_LINE;
                    triangle+=repeatString(HORIZONTAL_LINE, length*2)+NEW_LINE;
                } else {
                    triangle+=repeatString(SPACE, length-i)+LEFT_LINE+repeatString(SPACE, (i-1)*2)+RIGHT_LINE+NEW_LINE;
                }
            }
            return triangle;
          }
        
    },
    Square{
        @Override
        public String printFigure(int length) {
            String square="";
        for (int i=1; i<=length; i++){
            if (i==1){
                square+=SPACE+repeatString(HORIZONTAL_LINE, length*2)+NEW_LINE;
                square+=VERTICAL_LINE+repeatString(SPACE, length*2)+VERTICAL_LINE+NEW_LINE;
            } else if (i==length){
                square+=VERTICAL_LINE+repeatString(SPACE, length*2)+VERTICAL_LINE+NEW_LINE;
                square+=SPACE+repeatString(HORIZONTAL_LINE, length*2)+NEW_LINE;
            } else {
                square+=VERTICAL_LINE+repeatString(SPACE, length*2)+VERTICAL_LINE+NEW_LINE;
            }
        }
        return square;
          }
    };
    String HORIZONTAL_LINE="-";
    String VERTICAL_LINE="|";
    String LEFT_LINE="/";
    String RIGHT_LINE="\\"; 
    String SPACE=" ";
    String NEW_LINE="\n";

    public abstract String printFigure(int length); 

    private static String repeatString(String symbol, int times){
        String s="";
        for (int i=1; i<=times; i++){
            s+=symbol;
        }
        return s;
    }   
}
