package com.walking.lesson20_exeption.task1.model;

public class FileNotFoundException extends Exception{
    private String name;
    public String getName(){return name;}

    public FileNotFoundException(String message, String name){

        super(message);
        this.name=name;
    }

}

