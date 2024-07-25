package com.walking.lesson71_thread_safe_collections.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Создайте стрим на базе ArrayList и внутри стрима удаляйте элементы исходного списка.
 * Например, пусть каждый элемент удаляет сам себя.
 * <p>
 * Попробуйте сделать то же самое, но заменив ArrayList на CopyOnWriteArrayList.
 * Как изменился результат?
 * <p>
 * Можете попробовать также и с другими потокобезопасными и потоконебезопасными коллекциями.
 */
public class Main {
    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7);

//        var arr = new ArrayList<Integer>(numbers);
//        var resultFromArrayList = arr.stream()
//                .peek(arr::remove)
//                .toList();

        var copyAndWriteArrayList = new CopyOnWriteArrayList<>(numbers);
        var resultFromCopyAndWriteArrayList = copyAndWriteArrayList.stream()
                .peek(copyAndWriteArrayList::remove)
                .toList();

        System.out.printf("-> %s", copyAndWriteArrayList);
    }
}