package com.walking.lesson20_exceptions.task2.shapes;

public class TriangleShape extends RightShape {
    private static final String SHAPE_TYPE ="Triangle";
    private final int SIDE_SIZE;
    private static final String HORIZONTAL_LINE="-";
    private static final String VERTICAL_LINE="|";
    private static final String SLASH_LINE_LEFT="/";
    private static final String SLASH_LINE_RIGTH="\\";
    public TriangleShape(int sideSize) {
        super();
        SIDE_SIZE=sideSize;
        System.out.println("You selected "+ SHAPE_TYPE);
    }
    public String getShapeType(){
        return SHAPE_TYPE;
    }
    @Override
    public void drawShape(){
        System.out.println("\nDrawing "+ SHAPE_TYPE +"...");
        System.out.println(createShape());
    }
    private String createShape(){
        String returnLine="";
        for (int i=0;i<SIDE_SIZE;i++){
            returnLine+=drawLine(i);
        }
        returnLine+=drawHorizontalLine(SIDE_SIZE,HORIZONTAL_LINE);
        return returnLine+="\n";
    }
    private String drawLine(int index){
        String returnLine="";
        returnLine+=VERTICAL_LINE;
        for (int i=0;i<index;i++){
            returnLine+=EMPTY_CHAR;
        }
        returnLine+=SLASH_LINE_RIGTH;
        for (int i=index;i<=SIDE_SIZE;i++){
            returnLine+=EMPTY_CHAR;
        }
        return returnLine+="\n";
    }
}

