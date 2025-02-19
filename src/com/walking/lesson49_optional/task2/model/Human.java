package com.walking.lesson49_optional.task2.model;

import com.walking.lesson49_optional.task2.model.Car.Car;

import java.util.ArrayList;
import java.util.List;


public class Human {
    private final String name;
    private final Human mother;
    private final Human father;
    private List<Human> children = new ArrayList<>();
    private String profession;
    private Home home;
    private Car car;

    public Human(String name, Human mother, Human father, String profession, Home home, Car car) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.profession = profession;
        this.home = home;
        this.car = car;
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

    public List<Human> getChildren() {
        return children;
    }

    public String getProfession() {
        return profession;
    }

    public Home getHome() {
        return home;
    }

    public Car getCar() {
        return car;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private String childrenToString() {
        String res = "";

        for (Human child : children) {
            res += child.getName() + ", ";
        }

        return res;
    }

    @Override
    public String toString() {
        return String.format("""
                name: %s,
                mother: %s,
                father: %s,
                profession: %s,
                home: %s""",
                name,
                mother,
                father,
                profession,
                home);
    }
}
