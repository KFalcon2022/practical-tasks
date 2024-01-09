package com.walking.lesson50_streamAPI.task7;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas
 * Поделите людей на детей и взрослых
 * (понадобится специальный Collector)
 */

import com.walking.lesson50_streamAPI.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Petro",10));
        people.add(new Person("Ivan",90));
        people.add(new Person("Maxim",15));
        people.add(new Person("Zoya",18));
        people.add(new Person("Ilya",17));
        Map<Boolean,List<Person>> dividedPeople = partitionAdults(people);

        dividedPeople.forEach((a,b)->{
            System.out.println("\n"+a+" - ");
            b.forEach(p-> System.out.println(p.getName()+" "+p.getAge()));
        });
    }
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(p->p.getAge()>=18));
    }

    //Исходный код
//    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
//        Map<Boolean, List<Person>> map = new HashMap<>();
//        map.put(true, new ArrayList<>());
//        map.put(false, new ArrayList<>());
//        for (Person person : people) {
//            map.get(person.getAge() >= 18).add(person);
//        }
//        return map;
//    }
}
