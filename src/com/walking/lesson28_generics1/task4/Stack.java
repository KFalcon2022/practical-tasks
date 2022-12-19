package com.walking.lesson28_generics1.task4;

import java.lang.reflect.Array;

public class Stack<T> {
    private int size;
    private T[] stackarray;
    private int top;


    public Stack(int size) {
        this.size = size;
        stackarray = (T[]) Array.newInstance(Object.class, size);
        top = -1;
    }

    public void addElement(Object c) {
        if (size - 1 == top) {
            System.out.println("нет мест, обьект " + c + " не может быть добавлен");

            return;
        }
        stackarray[++top] = (T) c;
        System.out.println("Добавлен обьект " + c);
    }


    public void deleteElement() {

        if (top == -1) {
            throw new RuntimeException("Вы пытаетесь удалить элемент которого нет");
        } else {
            stackarray[top] = null;
            --top;
        }
    }

    public T find(T value) {
        for (T i : stackarray) {
            if (!(i == null) && i == value) {
                System.out.print("Элемент найден: ");

                return i;
            }
        }
        throw new RuntimeException("Не найден элемент, извините");
    }

    //глубина стека
    public int getTop() {
        if (top < 0) {

            return 0;
        }

        return top + 1;
    }

    public String show() {
        String result = "([";

        for (T i : stackarray) {
            if (!(i == null)) {
                result += i.toString();
            }

            if (stackarray.length > 1) {
                result += ",";
            }
        }
        result += "])";

        return result;
    }

}
