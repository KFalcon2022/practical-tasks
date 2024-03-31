package com.walking.lesson71_thread_safe_collections.task2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

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
        Random intRandom = new Random();
        List<Integer> arrayList = new ArrayList<>();
//        CopyOnWriteArrayList<Integer> arrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }
        try {
            arrayList.stream()
                    .peek(i -> {
                        System.out.println("Remove " + i);
                        arrayList.remove(i);
                        System.out.println("Removed " + i);
                    })
                    .toList();
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception " + e);
        }
    }
}