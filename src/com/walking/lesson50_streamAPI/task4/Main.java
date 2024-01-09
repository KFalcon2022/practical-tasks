package com.walking.lesson50_streamAPI.task4;

import com.walking.lesson50_streamAPI.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas
 * Метод должен возвращать самого старого человека из коллекции людей на входе
 */

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("",10));
        people.add(new Person("",9));
        people.add(new Person("",15));
        System.out.println(getOldestPerson(people).getAge());

    }
    public static Person getOldestPerson(List<Person> people){
        return people.stream()
                //.max((o1, o2) -> o1.getAge()-o2.getAge())
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow();

    }

    //Исходный код
//    public static Person getOldestPerson(List<Person> people) {
//        Person oldestPerson = new Person("", 0);
//        for (Person person : people) {
//            if (person.getAge() > oldestPerson.getAge()) {
//                oldestPerson = person;
//            }
//        }
//        return oldestPerson;
//    }
}
