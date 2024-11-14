package com.walking.lesson71_thread_safe_collections.task2;

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
        CopyOnWriteArrayList<Integer> array=new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }   
        var result=array.stream().peek(array::remove).toList();
        System.out.println(result);
        System.out.println(array);
    }
}