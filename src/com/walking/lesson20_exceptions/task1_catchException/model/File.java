package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private int size;
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    private TypeFile type;
    public TypeFile getType() {
        return type;
    }

    public File(String name, TypeFile type){
        this.name=name;
        this.type=type;
        this.size=0;
    }

    public File(String name, TypeFile type, int size){
        this(name, type);
        this.size=size;
    }

    @Override
    public String toString(){
        return getName()+" type:"+getType()+" size:"+getSize()+"b";
    }
}
