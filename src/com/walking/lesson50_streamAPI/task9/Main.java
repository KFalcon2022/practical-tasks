package com.walking.lesson50_streamAPI.task9;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas
 * Верните строку имен, разделенных запятой
 */

import com.walking.lesson50_streamAPI.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Petro",10,"Russian"));
        people.add(new Person("Ivan",90,"Russian"));
        people.add(new Person("Maxim",15, "Georgian"));
        people.add(new Person("Zoya",18,"Thailand"));
        people.add(new Person("Ilya",17,"Thailand"));
        people.add(new Person("Petya",44,"Thailand"));

        System.out.println(namesToString(people));
    }
    public static String namesToString(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .reduce(((s1,s2)->s1+", "+s2))
                .orElseThrow();
    }

    //Исходный код
//    public static String namesToString(List<Person> people) {
//        String label = "Names: ";
//        StringBuilder sb = new StringBuilder(label);
//        for (Person person : people) {
//            if (sb.length() > label.length()) {
//                sb.append(", ");
//            }
//            sb.append(person.getName());
//        }
//        sb.append(".");
//        return sb.toString();
//    }
}
