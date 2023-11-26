package com.walking.lesson39.task1;

import com.walking.lesson39.task1.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        addStringElementsToList(list);

        System.out.println(list);
        list.deleteNodesWhereHashIsEven();
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }

    static void addStringElementsToList(SinglyLinkedList<String> list) {
        for (int i = 0; i < 20; i++) {
            list.addElement(String.valueOf(i));
        }
    }

}
