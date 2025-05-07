package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.task1.structure.LinkedList;

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
        LinkedList<Integer> integers = new LinkedList<>();

        integers.reverse();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        System.out.println("Список после добавления элементов:\n" + integers);

        integers.reverse();
        System.out.println("Развернутый список:\n" + integers);

        integers.alternativeReverse();
        System.out.println("Развернутый список (альтернативный способ):\n" + integers);

        integers.add(0);
        integers.add(0);
        integers.add(2);
        integers.add(2);
        System.out.println("Список после добавления элементов:\n" + integers);

        integers.deleteAllWithEvenHash();
        System.out.println("Удалили элементы с четными хеш-кодами:\n" + integers);
    }
}