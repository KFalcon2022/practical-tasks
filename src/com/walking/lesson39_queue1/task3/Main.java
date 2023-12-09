package com.walking.lesson39_queue1.task3;

import com.walking.lesson39_queue1.collections.DoublyLinkedList;
import com.walking.lesson39_queue1.service.CollectionService;

import java.util.ArrayList;

/**
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> doublyLinkedList2=new DoublyLinkedList<>();
        DoublyLinkedList<Integer> doublyLinkedList3=new DoublyLinkedList<>();
        DoublyLinkedList<Integer> doublyLinkedList4=new DoublyLinkedList<>();
        fillListInteger(doublyLinkedList1);
        fillListInteger(doublyLinkedList2);
        doublyLinkedList3.add(100);
        doublyLinkedList3.add(99);
        doublyLinkedList4.add(44);
        doublyLinkedList4.add(51);
        doublyLinkedList4.add(100);

        String[] arrayStrings=new String[doublyLinkedList1.size()];
        arrayStrings[0]="1";
        arrayStrings[0]="2";

        System.out.println("Original list:");
        System.out.println(doublyLinkedList1);

        System.out.println("\nOriginal list with LIFO reading:");
        System.out.println(doublyLinkedList1.toStringLIFO());

        System.out.println("\nisEmpty ="+doublyLinkedList1.isEmpty());
        System.out.println("List contains 44: "+doublyLinkedList1.contains(44));
        System.out.println("List contains 100: "+doublyLinkedList1.contains(100));
        System.out.println("Iterator first value: "+doublyLinkedList1.iterator().next());
        System.out.println("toArray: "+doublyLinkedList1.toArray().toString()+"| Class - "+doublyLinkedList1.toArray().getClass());
        System.out.println("toArray in String: "+doublyLinkedList1.toArray(new Integer[0]).toString()+"| Class - "+doublyLinkedList1.toArray(new Integer[0]).getClass());
        System.out.println("After remove 1: "+doublyLinkedList1.remove(1)+" | "+doublyLinkedList1);
        doublyLinkedList2.remove(1);
        System.out.println("Contains second collection (same elements): "+doublyLinkedList1.containsAll(doublyLinkedList2));
        System.out.println("Contains third collection (no elements): "+doublyLinkedList1.containsAll(doublyLinkedList3));
        System.out.println("Contains fourth collection (one element): "+doublyLinkedList1.containsAll(doublyLinkedList4));
        System.out.println(doublyLinkedList1);
        System.out.println("addAll (same (different elements): "+doublyLinkedList1.addAll(doublyLinkedList3));
        System.out.println(doublyLinkedList1);
        System.out.println("remove all (collection with 44, 100): "+doublyLinkedList1.removeAll(doublyLinkedList4));
        System.out.println(doublyLinkedList1);
        System.out.println("retainAll (only 100): "+doublyLinkedList1.retainAll(doublyLinkedList3));
        System.out.println(doublyLinkedList1);
        doublyLinkedList1.clear();
        System.out.println("Clear: "+doublyLinkedList1+", size: "+doublyLinkedList1.size());

        fillListInteger(doublyLinkedList1);
        System.out.println(doublyLinkedList1);

        System.out.println("\nList after deleting odd Hashcode nodes:");
        CollectionService.deleteOddHashcodeNodes(doublyLinkedList1);
        System.out.println(doublyLinkedList1);
    }
    static void fillListInteger(DoublyLinkedList<Integer> list){
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(21);
        list.add(44);
        list.add(45);
        list.add(19);
        list.add(1);
        list.add(0);
    }
}
