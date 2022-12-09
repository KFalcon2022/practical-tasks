package com.walking.lesson21.Task1.model;

// в учебных целях воспользовался StringJoiner и String.split

import java.util.StringJoiner;

public final class Person {
    private final String fio;

    public Person(String owner){
        fio = owner;
    }

    @Override
    public String toString(){
        return fio;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {return true;}
        if (o == null) {return false;}
        return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode(){
        return fio.hashCode();
    }
}
