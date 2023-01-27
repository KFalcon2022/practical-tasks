package com.walking.lesson17_enum.task3.validators;

import com.walking.lesson17_enum.task3.model.EquilateralShape;

public class ShapeTypeValidator {
    public boolean validate(int type) {
        return type == EquilateralShape.EQUILATERAL_TRIANGLE.getType() || type == EquilateralShape.SQUARE.getType();
    }
}
