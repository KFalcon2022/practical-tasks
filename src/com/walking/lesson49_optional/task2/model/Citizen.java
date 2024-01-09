package com.walking.lesson49_optional.task2.model;

import java.util.ArrayList;

public class Citizen {
    private String name;
    private Citizen mother;
    private Citizen father;
    private ArrayList<Citizen> children=new ArrayList<>();
    private Housing house;
    private Car car;
    private String profession;
    public Citizen(){};

    public Citizen(String name, Citizen mother, Citizen father, ArrayList<Citizen> children, Housing house, Car car, String profession) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.house = house;
        this.car = car;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public Citizen getMother() {
        return mother;
    }

    public Citizen getFather() {
        return father;
    }

    public ArrayList<Citizen> getChildren() {
        return children;
    }

    public Housing getHouse() {
        return house;
    }

    public Car getCar() {
        return car;
    }

    public String getProfession() {
        return profession;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(Citizen mother) {
        this.mother = mother;
    }

    public void setFather(Citizen father) {
        this.father = father;
    }

    public void setHouse(Housing house) {
        this.house = house;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    @Override
    public String toString(){
        return """
                %s, %s, %s"""
                .formatted(
                        name,
                        profession,
                        house.getAddress());
    }
}
