package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Square implements EquilateralShape{
    private int length;
    public Square(int length)
    {
        this.length = length;
    }
    @Override
    public String getStringShape() {
        String stringShape = "";
        for (int i = 0; i < length; i++) {
            stringShape += "-";
        }
        for (int j = 2; j < length; j++) {
            stringShape+="\n";
            stringShape+="|";
            for (int i = 2; i < length; i++) {
                stringShape+=" ";
            }
            stringShape+="|";
        }
        stringShape+="\n";
        for (int i = 0; i < length; i++) {
            stringShape+="-";
        }
        stringShape+="\n";
        return stringShape;
    }
    public int getLength(){
        return length;
    }
}
