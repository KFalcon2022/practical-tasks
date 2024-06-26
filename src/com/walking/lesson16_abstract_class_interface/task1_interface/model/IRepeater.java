package com.walking.lesson16_abstract_class_interface.task1_interface.model;

interface IRepeater {
    default String repeatString(String symbol, int times){
        String s="";
        for (int i=1; i<=times; i++){
            s+=symbol;
        }
        return s;
    }
}
