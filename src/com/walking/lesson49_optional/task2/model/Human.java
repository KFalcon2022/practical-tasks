package com.walking.lesson49_optional.task2.model;

import com.walking.lesson49_optional.task2.model.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Human {
    private final String name;
    private Human mother;
    private Human father;
    private Car car;
    private String profession;
    private House house;
    private final List<Human> child = new ArrayList<>();

    public List<Human> getChild() {
        return child;
    }

    public void addChild(Human child) {
        int childCound = this.child.size();
        this.child.add(++childCound, child);
    }

    public Human(String name) {
        this(name, null, null, null, null, null);
    }

    public Human(String name, Human mother, Human father, Car car, String profession, House house) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.car = car;
        this.profession = profession;
        this.house = house;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
