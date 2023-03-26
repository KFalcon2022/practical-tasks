package com.walking.lesson57_stream;

public class Employee {
    private String name;
    private boolean isMale;
    private String position;
    private int age;

    public Employee(String name, boolean isMale, String position, int age) {
        this.name = name;
        this.isMale = isMale;
        this.position = position;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public boolean getSex() {
        return this.isMale;
    }

    public String getPosition() {
        return this.position;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString(){
        return "%s %s %d".formatted(this.name, this.position, this.age);
    }
}