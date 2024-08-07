package com.walking.lesson39_queue1.task3;

import com.walking.lesson39_queue1.task3.model.TwoLinkedList;

/**
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        TwoLinkedList<String> list=new TwoLinkedList<>();
        // list.addFirst("1");
        // list.addFirst("2");
        // list.addFirst("3");
        // list.addFirst("4");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        System.out.println(list.delEvenHashcode());
        list.roll();
        // System.out.println(list.delFirst());
        // list.addFirst("1");
        // System.out.println(list.delLast());
        // list.addLast("4");
        // System.out.println(list.delByIndex(6));
        // System.out.println(list.addToIndex("4", 0));
        // System.out.println(list.addToIndex("4", 1));
        // System.out.println(list.addToIndex("3", 1));
        // System.out.println(list.addToIndex("1", 1));
        // System.out.println(list.addToIndex("2", 2));
        // System.out.println(list.getIndexByValue("3"));
        // System.out.println(list.getIndexByValue("1"));
        // System.out.println(list.getIndexByValue("4"));
        // System.out.println(list.getIndexByValue("5"));
        // System.out.println(list.getValueByIndex(1));
        // System.out.println(list.getValueByIndex(3));
        // System.out.println(list.getValueByIndex(4));
    }
}
