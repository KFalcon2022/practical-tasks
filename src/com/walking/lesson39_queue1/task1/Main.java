package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.collection.SinglyLinkedList;
import com.walking.lesson39_queue1.util.CollectionUtils;

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
    //    В рамках реализации списка я выбрал реализацию в рамках 2й задачи 37го урока. В целом, прямой необходимости
//    делать коллекцию наследником Collection или другого интерфейса не было. Единственная доработка - метод reverse()
    public static void main(String[] args) {
        SinglyLinkedList<Integer> testIntList = createTestIntList();
        testIntList.reverse();
        System.out.println(testIntList.getTop());

        System.out.println(testIntList.size());
//        В целом, решения могут быть разные, в т.ч. возвращающие из метода новую коллекцию.
        CollectionUtils.dropEvenHashCodeElements(testIntList);
        System.out.println(testIntList.size());
    }

    private static SinglyLinkedList<Integer> createTestIntList() {
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
