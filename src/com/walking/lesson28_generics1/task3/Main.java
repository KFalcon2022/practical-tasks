package com.walking.lesson28_generics1.task3;

import com.walking.lesson28_generics1.task3.model.FindingValueInArray;

import java.io.FileNotFoundException;

/**
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */
public class Main {
    public static void main(String[] args) {

        Integer[] IntArr = new Integer[]{12, 2, 23, 25, 69, 78, 45, 65, 15, 23, 56, 45, 78, 45, 25, 28};
        String[] strArr = new String[]{"Sasha", "Petya", "Vasya", "ahmed", "Oleg"};
        FindingValueInArray <Integer> genIntArr = new FindingValueInArray<>(IntArr, 1);
        FindingValueInArray <String> genStrArr = new FindingValueInArray<>(strArr, "Oleg");

        try {
            System.out.println("Value is found!: " + genIntArr.findVal(genIntArr.getArr(), genIntArr.getSearchVal()));
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Value is found!: " + genStrArr.findVal(genStrArr.getArr(), genStrArr.getSearchVal()));
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}
