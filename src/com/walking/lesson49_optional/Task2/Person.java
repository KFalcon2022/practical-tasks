package com.walking.lesson49_optional.Task2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Profession position;
    private Person father;
    private Person mother;
    private List<Person> children = new ArrayList<>();
    private Address address;
    private Car car;

    public Person(String name, Profession position, Address address) {
        this.name = name;
        this.position = position;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Profession getPosition() {
        return position;
    }

    public String getAddress() {
        return address.getAddress();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public void setMother(Person mother) {
        this.mother = mother;
        this.mother.addChild(this);
    }

    public void setFather(Person father) {
        this.father = father;
        this.father.addChild(this);
    }
}
