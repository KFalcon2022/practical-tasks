package com.walking.lesson57_stream_collect_collector.model;

import java.util.Objects;

public class Employee {
    private String name;
    private boolean isMale;
    private String position;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return isMale() == employee.isMale() && getAge() == employee.getAge() && Objects.equals(getName(), employee.getName()) && Objects.equals(getPosition(), employee.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isMale(), getPosition(), getAge());
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

    public void setMale(boolean male) {
        isMale = male;
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

    private int age;
}
