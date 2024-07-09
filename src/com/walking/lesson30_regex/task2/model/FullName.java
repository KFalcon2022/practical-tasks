package com.walking.lesson30_regex.task2.model;

public class FullName {
    private String lastName;
    private String name;
    private String surName;
    public FullName(String lastName, String name, String surName){
        this.lastName=lastName;
        this.name=name;
        this.surName=surName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString(){
        return lastName+" "+name+" "+surName;
    }
}
