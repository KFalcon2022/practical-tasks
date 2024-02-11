package com.walking.lesson16_abstract_class_interface.task1_abstract_class.shapes;

public class SquareShape extends RightShape {
    private static final String SHAPE_TYPE ="Square";
    private final int SIDE_SIZE;
    private static final String HORIZONTAL_LINE="-";
    private static final String VERTICAL_LINE="|";
    public SquareShape(int sideSize) {
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
        String figureLines="";
        figureLines+=drawHorizontalLine(SIDE_SIZE,HORIZONTAL_LINE);
        for (int i=0;i<SIDE_SIZE;i++){
            figureLines+= drawVerticalLine();
        }
        figureLines+=drawHorizontalLine(SIDE_SIZE,HORIZONTAL_LINE);
        return figureLines;
    }
    private String drawVerticalLine(){
        String resultLine="";
        resultLine+=VERTICAL_LINE;
        for (int i=1;i<SIDE_SIZE-1;i++){
            resultLine+=EMPTY_CHAR;
        }
        resultLine+=VERTICAL_LINE;
        return resultLine+="\n";
    }
    /**private String drawHorizontalLine(){
     String resultLine="";
     for (int i=0;i<SIDE_SIZE;i++) {
     resultLine += HORIZONTAL_LINE;
     }
     return resultLine+="\n";
     }
     **/
}

