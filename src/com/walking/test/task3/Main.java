package com.walking.test.task3;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<LocalDateTime> list = getDates();
        list.forEach(date-> System.out.println(date.getNano()));
        Set<LocalDateTime> set = new TreeSet<>();
        set.addAll(list);
        set.forEach(System.out::println);
//        System.out.println(list);
    }
    private static List<LocalDateTime> getDates() {
        List<LocalDateTime> list = new ArrayList<>();
        for (int i=0; i<20; i++) {
            list.add(LocalDateTime.now());
        }
        return list;
    }

}
