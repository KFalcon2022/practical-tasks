package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public interface EquilateralShape {
    //    Поля интерфейса - всегда public static final
    String EMPTY_ELEMENT = " ";
    String EMPTY_STRING = "";
    char NEW_LINE_SYMBOL = '\n';

    //    Мы не можем определить поле length в интерфейсе, но может указать, что каждый наследник обязан
//    определить поведение метода по получению значения length
    int getLength();

    String createShapeString();
}
