package com.walking.lesson25_nested_classes.task1.anonymous_class.model;

public interface EquilateralShape {

    //    Мы не можем определить поле length в интерфейсе, но может указать, что каждый наследник обязан
//    определить поведение метода по получению значения length
    int getLength();

    String getStringShape();
}
