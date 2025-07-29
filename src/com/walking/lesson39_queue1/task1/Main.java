package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.collection.SinglyLinkedList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

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
        SinglyLinkedList<Integer> testIntegerList = createIntegerList();
        testIntegerList.reverse();

        for (Integer i : testIntegerList) {
            System.out.println(i);
        }
    }

    private static @NotNull SinglyLinkedList<Integer> createIntegerList() {
        SinglyLinkedList<Integer> testIntegerList = new SinglyLinkedList<>();
        testIntegerList.add(1);
        testIntegerList.add(2);
        testIntegerList.add(3);
        testIntegerList.add(4);
        testIntegerList.add(5);
        testIntegerList.add(6);
        testIntegerList.add(7);

        return testIntegerList;
    }

    private static <E> void dropEvenHashCodeElement(Collection<E> c) {
        Iterator<E> iterator = c.iterator();

        while (iterator.hasNext()) {
            E e = iterator.next();

            if (e.hashCode() % 2 == 0) {
                c.remove(e);
            }
        }
    }
}
