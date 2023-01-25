package com.walking.lesson17_enum.task3.validators;

import com.walking.lesson17_enum.task3.model.EquilateralShape;

public class ShapeTypeValidator {
    private int type;

    public ShapeTypeValidator(int type) {
        this.type = type;
    }

    public boolean validate() {
        return type == EquilateralShape.EQUILATERAL_TRIANGLE.getType() || type == EquilateralShape.SQUARE.getType();
    }
}
