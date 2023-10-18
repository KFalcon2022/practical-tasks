package com.walking.lesson30_regex.task2.model;

public class FullName {
    private final String name;
    private final String lastName;
    private final String middleName;
    public FullName (String lastName,String name, String middleName){
        this.lastName=lastName;
        this.name=name;
        this.middleName=middleName;
    }
    @Override
    public String toString(){
        return lastName+" "+name+" "+middleName;
    }
}
