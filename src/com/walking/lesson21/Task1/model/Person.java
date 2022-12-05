package com.walking.lesson21.Task1.model;

// в учебных целях воспользовался StringJoiner и String.split

import java.util.StringJoiner;

public final class Person {
    private final String name;
    private final String surname;

    public Person(String owner){
        String[] args = owner.split(" ");
        this.name = args[0];
        this.surname = args.length > 1 ? args[1] : "?";
    }

    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner(" ", "\"", "\"");
        sj.add(name).add(surname);
        return sj.toString();
    }
}
