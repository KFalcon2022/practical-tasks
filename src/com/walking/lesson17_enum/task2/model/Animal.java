package com.walking.lesson17.task2.model;

public abstract class Animal implements CanTalk {

    private static String S_INFO_PATTERN = "%s %s (%d y.o.) says: ";

    public final ANIMALS specie;
    private final String name;
    private final int age;

    public Animal(String name, int age, ANIMALS specie) {
        this.name = name;
        this.age = age;
        this.specie = specie;
    }
    
    public void printInfo() {
        System.out.print(String.format(S_INFO_PATTERN, specie, name, age));
    }
    
    public void talk(String message){
        System.out.println(message);
    }
}
 