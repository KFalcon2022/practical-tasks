package com.walking.lesson20_exeption.task1.model;

public class File {
    String name;
    int size;
    Extension extension;
    public File(String name,int size,Extension extension){
        this.name=name;
        this.extension=extension;
        this.size=size;
    }
    public String getName(){
        return name;
    }
    public String getAll(){
        return "Файл: "+ name + "." + extension + " размер:" + size;
    }
}
