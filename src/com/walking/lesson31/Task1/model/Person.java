package com.walking.lesson31.Task1.model;

import java.io.Serializable;

public final class Person implements Serializable {
    private final String name;
    private final String secondName;
    private final String familyName;

    public Person(String owner){
        String[] data = owner.split(" ");
        Validator validator = new Validator(null);
        familyName = validator.capitalize(data[0]);
        name = (data.length > 1) ? validator.capitalize(data[1]) : "";
        secondName = (data.length > 2) ? validator.capitalize(data[2]) : "";
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(familyName)
                .append(" ")
                .append(name)
                .append(" ")
                .append(secondName)
                .toString()
                .strip()
                .replace("  ", " ");
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {return true;}
        if (o == null) {return false;}
        return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode(){
        return name.hashCode() * 7 + secondName.hashCode() * 11 + familyName.hashCode() * 13;
    }
}
