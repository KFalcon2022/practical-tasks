package com.walking.lesson71_thread_safe_collections.task2;

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
        var numbers = List.of(0, 1, 2, 3, 4, 5);

//        var arrayList = new ArrayList<>(numbers);
//        var resultFromArrayList = arrayList.stream()
//                .peek(arrayList::remove)
//                .toList(); // ConcurrentModificationException
//
//        System.out.println(arrayList); // Упадем раньше. Но если стрим выше обернуть в try-catch -
//        // остались бы лишь четные (при индексации элементов с 1-го, а не 0-го) элементы.
//        // Почему - легко понять, если рассчитать сдвиги при удалении элементов

        var copyOnWriteArrayList = new CopyOnWriteArrayList<>(numbers);
        var resultFromCopyOnWriteArrayList = copyOnWriteArrayList.stream()
                .peek(copyOnWriteArrayList::remove) // Никаких ошибок
                .toList(); // [0, 1, 2, 3, 4, 5] - стрим создан из данных до удаления из списка

        System.out.println(copyOnWriteArrayList); // Список пуст
    }
}