package com.walking.lesson16_abstract_class_interface.task1_abstract_class.validators;

import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.EquilateralTriangle;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Square;

public class ShapeTypeValidator {
    private int type;

    public ShapeTypeValidator(int type) {
        this.type = type;
    }

    public boolean validate() {
        return type == Square.SHAPE_INDEX || type == EquilateralTriangle.SHAPE_INDEX;
    }
}
