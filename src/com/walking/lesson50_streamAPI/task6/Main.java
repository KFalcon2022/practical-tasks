package com.walking.lesson50_streamAPI.task6;

import com.walking.lesson50_streamAPI.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas
 * Получить имена всех детей, кто младше 18 лет
 */

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Petro",10));
        people.add(new Person("Ivan",90));
        people.add(new Person("Maxim",15));
        people.add(new Person("Zoya",18));
        people.add(new Person("Iliya",17));
        System.out.println(getKidNames(people));

    }
    public static Set<String> getKidNames(List<Person> people) {
        return people.stream()
                .filter(p->p.getAge()<18)
                .map(Person::getName)
                .collect(Collectors.toSet());
    }

    //Исходный код
//    public static Set<String> getKidNames(List<Person> people) {
//        Set<String> kids = new HashSet<>();
//        for (Person person : people) {
//            if (person.getAge() < 18) {
//                kids.add(person.getName());
//            }
//        }
//        return kids;
//    }
}
