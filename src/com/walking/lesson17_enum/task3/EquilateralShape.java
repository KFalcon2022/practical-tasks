package com.walking.lesson17_enum.task3;

public enum EquilateralShape {
    EQUILATERAL_TRIANGLE{
        @Override
        public void drawShape(int length ){
            for (int i=0;i<length-1;i++){
                drawLine(createTriangleLine(length,i));
            }
            drawLine(createHorizontalLine(length));
        }
    },
    SQUARE{
        @Override
        public void drawShape(int length){
            drawLine(createHorizontalLine(length));
            for (int i=0;i<length;i++){
                drawLine(createSquareLine(length));
            }
            drawLine(createHorizontalLine(length));
        }
    };
    private static final String VERTICAL_LINE="|";
    private static final String HORIZONTAL_LINE="-";
    private static final String SLASH_LINE="\\";
    private static final String SPACE_CHAR=" ";
    private static final String EMPTY_CHAR="";
    private static final String NEW_LINE_SIGNH="\n";
    abstract void drawShape(int length);
    private static String createHorizontalLine(int length){
        String resultLine=EMPTY_CHAR;
        for (int i=0;i<length;i++){
            resultLine+=HORIZONTAL_LINE;
        }
        return resultLine+=NEW_LINE_SIGNH;
    }
    private static String createTriangleLine(int length,int position){
        String resultLine=VERTICAL_LINE;
        for (int i=1;i<=position;i++){
            resultLine+=SPACE_CHAR;
        }
        resultLine+=SLASH_LINE;
        for (int i=position+1;i<length;i++){
            resultLine+=SPACE_CHAR;
        }
        return resultLine+=NEW_LINE_SIGNH;
    }
    private static String createSquareLine(int length){
        String resultLine=VERTICAL_LINE;
        for (int i=1;i<length-1;i++){
            resultLine+=SPACE_CHAR;
        }
        return resultLine+=VERTICAL_LINE+NEW_LINE_SIGNH;
    }
    private static void drawLine(String line){
        System.out.print(line);
    }
}
