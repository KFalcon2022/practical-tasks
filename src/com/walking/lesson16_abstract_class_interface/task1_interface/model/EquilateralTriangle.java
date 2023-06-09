package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class EquilateralTriangle implements EquilateralShape{
    private int length;
    public  EquilateralTriangle(int length)
    {
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String getStringShape() {
        String stringShape = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                stringShape += " ";
            }

            stringShape += "/";

            for (int j = 0; j < i * 2; j++) {
                stringShape += " ";
            }

            stringShape += "\\" + "\n";
        }

        stringShape += " ";

        for (int i = 0; i < length; i++) {
            stringShape += "--";
        }
        return stringShape;
    }
}
