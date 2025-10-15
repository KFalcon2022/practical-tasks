package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.task1.list.MyList;

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
        MyList<String> newList = new MyList<>();
        newList.add("4");
        newList.add("4");
        newList.add("4");
        newList.add("4");
        newList.add("4");

        System.out.println(newList);
        newList.remove("4");
        System.out.println(newList);
    }
}
