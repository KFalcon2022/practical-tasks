package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.task1.structure.SinglyLinkedList;

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
        SinglyLinkedList<Integer> testSinglyLinkedList = createTestIntStack();
        System.out.println(testSinglyLinkedList.getSize());

        System.out.println(testSinglyLinkedList.find(4));

        testSinglyLinkedList.delete(1);
        testSinglyLinkedList.add(8);
        testSinglyLinkedList.add(9);
        System.out.println(testSinglyLinkedList.getSize());

        System.out.println(testSinglyLinkedList);

        testSinglyLinkedList = testSinglyLinkedList.reverseStack();
        System.out.println(testSinglyLinkedList);
    }

    private static SinglyLinkedList<Integer> createTestIntStack() {
        SinglyLinkedList<Integer> testSinglyLinkedList = new SinglyLinkedList<>();
        testSinglyLinkedList.add(1);
        testSinglyLinkedList.add(2);
        testSinglyLinkedList.add(3);
        testSinglyLinkedList.add(4);
        testSinglyLinkedList.add(5);
        testSinglyLinkedList.add(6);
        testSinglyLinkedList.add(7);

        return testSinglyLinkedList;
    }
}
