package com.walking.lesson16_abstract_class_interface.task1_interface.shapes;

import com.walking.lesson16_abstract_class_interface.task1_interface.interfaces.RightShapeInterface;

public class TriangleShapeInterface implements RightShapeInterface {
    private static final String SHAPE_TYPE ="Triangle";
    private final int SIDE_SIZE;
    private static final String HORIZONTAL_LINE="-";
    private static final String VERTICAL_LINE="|";
    private static final String SLASH_LINE_LEFT="/";
    private static final String SLASH_LINE_RIGTH="\\";
    public TriangleShapeInterface(int sideSize) {
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

    @Override
    public String drawHorizontalLine(int sideSize, String horizontalLine) {
            String resultLine="";
            for (int i=0;i<sideSize;i++){
                resultLine+=horizontalLine;
            }
            return resultLine+"\n";
    }

    private String createShape(){
        String returnLine="";
        for (int i=0;i<SIDE_SIZE;i++){
            returnLine+=drawLine(i);
        }
        returnLine+=drawHorizontalLine(SIDE_SIZE,HORIZONTAL_LINE);
        return returnLine+"\n";
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
        return returnLine+"\n";
    }
}
