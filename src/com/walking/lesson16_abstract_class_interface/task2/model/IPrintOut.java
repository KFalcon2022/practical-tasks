package com.walking.lesson16_abstract_class_interface.task2.model;

public interface IPrintOut {

    default String output(){
        return "Unknown message";
    };
}
