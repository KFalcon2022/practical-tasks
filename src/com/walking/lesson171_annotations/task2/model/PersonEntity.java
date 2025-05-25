package com.walking.lesson171_annotations.task2.model;

import com.walking.lesson171_annotations.task2.annotation.Column;
import com.walking.lesson171_annotations.task2.annotation.Id;
import com.walking.lesson171_annotations.task2.annotation.Table;

@Table(schema = "core", name = "person")
public class PersonEntity {
    @Id
    private long id;

    @Column(name = "full_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private boolean male;

    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
