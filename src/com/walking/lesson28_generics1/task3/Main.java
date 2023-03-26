package com.walking.lesson28_generics1.task3;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {
        ArrayFinder <String> s = new ArrayFinder<>(new String []{"abc","cde","qwe","lll"});
        ArrayFinder <Integer> i = new ArrayFinder<>(new Integer[]{1,2,3,4,5});

        try {
            System.out.println(s.find("ddd"));
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            System.out.println(s.find("abc"));
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            System.out.println(i.find(0));
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            System.out.println(i.find(1));
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
