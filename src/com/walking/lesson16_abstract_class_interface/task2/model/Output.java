package com.walking.lesson16_abstract_class_interface.task2.model;

public interface Output {


    static void print(String string) {
        System.out.println(string);
    }

    void print();

}
