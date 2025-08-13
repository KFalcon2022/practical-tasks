package com.walking.lesson58_collection_lamda_param;

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
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }
}
