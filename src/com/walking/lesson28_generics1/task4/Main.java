package com.walking.lesson28_generics1.task4;

import com.walking.lesson28_generics1.task4.exceptions.ElementNotFoundException;

/**
 * Реализовать параметризованный класс, хранящий и обрабатывающий стек.
 * Стек — структура данных, в котором каждый элемент хранит ссылку на следующий.
 * Работает по принципу LIFO (последний вошел — первый вышел).
 * <p>
 * Реализовать следующие методы:
 * <p>
 * Добавление элемента в стек;
 * Удаление элемента из стека. При удалении несуществующего элемента – исключение;
 * Получение глубины (количества элементов) стека;
 * Поиск по стеку, при отсутствии искомого значения – исключение;
 * Получение строкового эквивалента элементов стека, представленных в виде массива
 * ([строковое представление элемента1, ..., строковое представление элементаN]).
 */
public class Main {
    public static void main(String[] args) throws ElementNotFoundException {
        StackService<String> nameList = new StackService<>();
        nameList.addElement("Vasya");
        nameList.addElement("Petya");
        nameList.addElement("Anton");
        nameList.addElement("Ahmed");
        nameList.addElement("Oleg");

        try {
            System.out.println("Element is found!: " + nameList.searchElement("Oleg"));
        }catch (ElementNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            nameList.removeElement("Anton");
        }catch (ElementNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("List length: " + nameList.getLength() + " elements");

        System.out.println(nameList);

    }
}
