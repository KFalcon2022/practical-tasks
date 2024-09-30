package com.walking.lesson57_stream_collect_collector.model;

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
    public void setName(String name) {
        this.name = name;
    }
    public boolean isMale() {
        return isMale;
    }
    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
