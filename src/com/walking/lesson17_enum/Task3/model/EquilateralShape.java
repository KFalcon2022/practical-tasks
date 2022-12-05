package com.walking.lesson17_enum.Task3.model;

public class EquilateralShape {
    public static final String EMPTY_ELEMENT = " ";
    public static final String EMPTY_STRING = "";
    public static final char NEW_LINE_SYMBOL = '\n';

    protected final int length;

    protected EquilateralShape(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String createShapeString() {
        return "Unknown shape";
    }

 enum Shapes{
        SQUARE(""),EQUILATERAL_TRIANGLE("");
        private String code;
        Shapes(String code){
            this.code=code;
        }

     public String  getCode(String code) {
         return code;
     }
 }

}