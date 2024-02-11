package com.walking.lesson39_queue1.service;

// Сделаю по аналогии с авторо для тренировки
// отдельный класс, через который идет взаимодействие со списком

import com.walking.lesson39_queue1.collections.DoublyLinkedList;

import java.util.Iterator;

public class CollectionService {
    public static <T> void deleteOddHashcodeNodes(DoublyLinkedList<T> list){
        Iterator<T> listIterator = list.iterator();
        while (listIterator.hasNext()){
            T t = listIterator.next();
            if ((t.hashCode() % 2) == 0){
                list.remove(t);
            }
        }
    }
}
