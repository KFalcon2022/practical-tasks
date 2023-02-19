package com.walking.lesson49_optional.Task3;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List.of(new Cat(), new Dog(), new Cow()).stream()
                .map(Animal::getInfo)
                .forEach(System.out::println);
    }
}
