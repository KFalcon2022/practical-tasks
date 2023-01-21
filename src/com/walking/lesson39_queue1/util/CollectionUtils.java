package com.walking.lesson39_queue1.util;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {
    //    Не самый лучший, но пример использования статических методов в Java
    public static <E> void dropEvenHashCodeElements(Collection<E> collection) {
        Iterator<E> iterator = collection.iterator();
//        Пример обработки коллекции через итератор
        while (iterator.hasNext()) {
            E e = iterator.next();

            if (e.hashCode() % 2 == 0) {
                collection.remove(e);
            }
        }
    }
}
