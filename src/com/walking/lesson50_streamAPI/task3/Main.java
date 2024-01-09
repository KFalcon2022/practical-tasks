package com.walking.lesson50_streamAPI.task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas
 * Вернуть список строк, на входе список списков строк
 */


public class Main {
    public static void main(String[] args) {
        List<String> col1 = new ArrayList<>();
        col1.add("aaa");
        col1.add("bbb");
        List<List<String>> col2 = new ArrayList<>();
        col2.add(col1);
        System.out.println(transform(col2));
    }
    public static List<String> transform(List<List<String>> collection) {
        return collection.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    //Исходный код
//    public static List<String> transform(List<List<String>> collection) {
//        List<String> newCollection = new ArrayList<>();
//        for (List<String> subCollection : collection) {
//            for (String value : subCollection) {
//                newCollection.add(value);
//            }
//        }
//        return newCollection;
//    }
}
