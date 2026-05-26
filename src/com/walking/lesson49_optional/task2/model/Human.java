package com.walking.lesson49_optional.task2.model;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human mother;
    private Human father;
    private final List<Human> kids = new ArrayList<>();
    private Housing housing;
    private Car car;
    private String profession;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, Human mother, Human father) {
        this.name = name;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, Human mother, Human father, Housing housing, String profession) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.housing = housing;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getKids() {
        return kids;
    }

    public void addKid(Human kid) {
        kids.add(kid);
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
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
}
