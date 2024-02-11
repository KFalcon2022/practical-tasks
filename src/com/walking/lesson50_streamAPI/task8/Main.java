package com.walking.lesson50_streamAPI.task8;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas
 * Сгруппируйте людей по национальностям (по аналогии с пред. заданием)
 */

import com.walking.lesson50_streamAPI.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Petro",10,"Russian"));
        people.add(new Person("Ivan",90,"Russian"));
        people.add(new Person("Maxim",15, "Georgian"));
        people.add(new Person("Zoya",18,"Thailand"));
        people.add(new Person("Ilya",17,"Thailand"));
        people.add(new Person("Petya",44,"Thailand"));
        Map<String,List<Person>> dividedPeople = groupByNationality(people);

        dividedPeople.forEach((a,b)->{
            System.out.println("\n"+a+" - ");
            b.forEach(p-> System.out.println(p.getName()+" "+p.getAge()));
        });
    }
    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getNationality));
    }

    //Исходный код
//    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
//        Map<String, List<Person>> map = new HashMap<>();
//        for (Person person : people) {
//            if (!map.containsKey(person.getNationality())) {
//                map.put(person.getNationality(), new ArrayList<>());
//            }
//            map.get(person.getNationality()).add(person);
//        }
//        return map;
//    }
}
