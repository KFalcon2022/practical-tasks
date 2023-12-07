package com.walking.lesson39_queue1.task1;

import com.walking.lesson28_generics1.task4.structure.Stack;

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
        Stack<Integer> testList = new Stack<>(33);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);

        System.out.println("Original list:");
        System.out.println(testList);

        System.out.println("\nReversed list:");
        testList=testList.reverseList();
        System.out.println(testList);

        System.out.println("\nList after delete odd nodes:");
        testList.deleteOddNodes();
        System.out.println(testList);

    }
}
