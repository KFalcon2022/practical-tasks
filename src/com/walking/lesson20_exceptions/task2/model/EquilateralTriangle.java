package com.walking.lesson20_exceptions.task2.model;

public class EquilateralTriangle extends EquilateralShape {
    public EquilateralTriangle(int length) {
        super(length);
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
