package com.walking.lesson49_optional.task2.model;

import com.walking.lesson49_optional.task2.model.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private final Human mother;
    private final Human father;
    private String name;
    private List<Human> children = new ArrayList<>();
    private Habitation habitation;
    private OccupationType occupationType;
    private Car car;

    public Human() {
        this(null, null);
    }

    public Human(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Habitation getHabitation() {
        return habitation;
    }

    public void setHabitation(Habitation habitation) {
        this.habitation = habitation;
    }

    public OccupationType getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(OccupationType occupationType) {
        this.occupationType = occupationType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
