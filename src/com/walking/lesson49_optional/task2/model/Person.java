package com.walking.lesson49_optional.task2.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final Person mother;
    private final Person father;
    private List<Person> children = new ArrayList<>();
    private final Home home;
    private final Car car;
    private final String profession;

    public Person(String name, Person mother, Person father, List<Person> children, Home home, Car car,
            String profession) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.home = home;
        this.car = car;
        this.profession = profession;
    }

    public String getName() {
        return name;
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

    public void addChild(Person child) {
        children.add(child);
    }

    public Home getHome() {
        return home;
    }

    public Car getCar() {
        return car;
    }

    public String getProfession() {
        return profession;
    }
}
