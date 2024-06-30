package com.walking.lesson65_atomics.task1;

import com.walking.lesson65_atomics.task1.model.Counter;

/**
 * Реализуйте сервис управления счетчиками.
 * Счетчики могут добавляться и удаляться,
 * в самих счетчиках могут изменяться значения – как увеличиваться,
 * так и уменьшаться. Также возможен сброс счетчика до 0 (нуля).
 * <p>
 * Гарантируйте возможность безопасной работы с данным сервисом.
 */
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter("Счетчик", "Целые числа");
    }
}