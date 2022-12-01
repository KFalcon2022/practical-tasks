package com.walking.lesson16_abstract_class_interface.task3;

public abstract class Animal implements Voice {
    String species;

    protected void setName(String species) {
        this.species = species;
    }

    public abstract void voice();
}