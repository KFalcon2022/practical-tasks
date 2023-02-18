package com.walking.lesson49_optional.task2.model;


import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Person mother;
    private Person father;
    private final List<Person> children = new ArrayList<>();
    private Housing housing;
    private Car car;
    private String profession;

    public Person(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChildren(Person child) {
        if (child != null) {
            this.children.add(child);
        }
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

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }
}
