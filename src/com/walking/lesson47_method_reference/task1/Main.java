package com.walking.lesson47_method_reference.task1;

import java.util.LinkedList;

/**
 * Создайте произвольный список элементов.
 * Выведите каждый из элементов в консоль.
 * Параметр forEach() опишите как method reference.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<String> ll=new LinkedList<>();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.forEach(System.out::println);
    }
}
