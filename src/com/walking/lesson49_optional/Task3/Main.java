package com.walking.lesson49_optional.Task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static Map<String, String> soundMap = new HashMap();
    public static void main(String[] args) {
        soundMap.put("meow", "кот");
        soundMap.put("woof", "собака");
        soundMap.put("moo", "корова");

        List.of(new Cat(), new Dog(), new Cow()).stream()
                .map(Animal::sound)
                .forEach(Main::testAnimal);
    }

    public static void testAnimal(String sound) {
        Optional.of(sound)
                .map(soundMap::get)
                .ifPresent(e -> System.out.println("Это %s, он (она) говорит %s".formatted(e, sound)));
    }
}
