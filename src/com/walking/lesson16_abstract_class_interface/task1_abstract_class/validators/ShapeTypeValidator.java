package com.walking.lesson16_abstract_class_interface.task1_abstract_class.validators;

import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.EquilateralTriangle;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Square;

public class ShapeTypeValidator {
    public ShapeTypeValidator(int type) throws Exception {
        if (!(type == Square.SHAPE_INDEX || type == EquilateralTriangle.SHAPE_INDEX)) {
            throw new Exception("Нет реализации такой фигуры");
        }
    }
}
