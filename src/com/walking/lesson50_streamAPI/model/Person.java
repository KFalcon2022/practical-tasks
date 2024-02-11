package com.walking.lesson50_streamAPI.model;

public class Person {
    private int age;
    private String name;
    private String nationality;
    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    public Person(String name,int age, String nationality) {
        this.age = age;
        this.name = name;
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }
}
