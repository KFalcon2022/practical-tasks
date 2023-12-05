package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.collection.SinglyLinkedList;

/**
 * Реализуйте односвязный список (можно использовать реализацию в рамках
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson28_generics1/task4/structure/Stack.java">...</a>).
 * <p>
 * Реализуйте метод, разворачивающий односвязный список
 * (первый элемент должен стать последним, второй – предпоследним и т.д.).
 * <p>
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = initList();
        System.out.println("Размер стека: " + list.size());

        list.add(8);
        System.out.println("Размер стека: " + list.size());

        list.delete(3);
        System.out.println("Размер стека: " + list.size());

        System.out.println(list.find(5));

        System.out.println(list);

        list.reverseList();
        System.out.println(list);
    }

    private static SinglyLinkedList<Integer> initList() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        return list;
    }
}
