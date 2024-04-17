package com.walking.lesson39_queue1.utils;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtilits {
    public static <T> void removeEvenHashNode(Collection<T> coll) {
        Iterator<T> iterator = coll.iterator();

        while (iterator.hasNext()) {
            T elem = iterator.next();

            if (elem.hashCode() % 2 == 0) {
                coll.remove(elem);
            }
        }
    }
}
