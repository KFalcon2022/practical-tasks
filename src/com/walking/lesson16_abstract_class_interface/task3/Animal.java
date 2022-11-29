//package com.walking.lesson16_abstract_class_interface.task3;

import java.util.Scanner;

public abstract class Animal implements CanTalk {

    private static String S_INFO_PATTERN = "%s (%d y.o.)";
    private final String name;
    private final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getInfo() {
        return String.format(S_INFO_PATTERN, name, age);
    }
    
    public String talk(){
        return "*nothing*";
    }
}

