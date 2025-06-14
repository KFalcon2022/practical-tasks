package com.walking.lesson16_abstract_class_interface.task1_abstract_class.figures;

public class Unknown extends RegularFigure {

    public Unknown(int length) {
        super(length);
    }

    @Override
    public String getFigure() {
        return "Неизвестная фигура";
    }
}
