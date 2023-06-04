package com.walking.lesson16_abstract_class_interface.task3.model;

public interface Animal {

    default void sound() {
        System.out.println("Unknown animal!");
    }
}
