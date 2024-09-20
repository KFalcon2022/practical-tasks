package com.walking.lesson49_optional.task2.model;

import java.util.LinkedList;

public class Human {
    public String name;
    public Human mother;
    public Human father;
    public LinkedList<Human> children;
    public House house;
    public Car car;
    public String profession;

    public Human(String address, String profession, String name){
        this.name=name;
        this.profession=profession;
        this.house=new House(address);
        this.children=new LinkedList<>();
    }
}
