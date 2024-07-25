package com.walking.lesson28_generics1.task4.model;

import com.walking.lesson28_generics1.task4.exception.ElementDoesNotExist;
import com.walking.lesson28_generics1.task4.exception.ElementNotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class Stack<T> {
    private final Object[] stack;
    private int tos;

    public Stack(int size) {
        stack = new Object[size];
        tos = -1;
    }

    public void push(T item) {
        if (tos == stack.length - 1) {
            System.out.println("Стек полон");
        } else {
            stack[++tos] = item;
        }
    }

    public Object pop() {
        if (tos < 0) {
            throw new ElementDoesNotExist("Елемент не существует.");
        } else {
            return stack[tos--];
        }
    }

    public Object getValue(T value) {
        for (Object obj : stack) {
            if (Objects.equals(obj, value)) {
                return obj;
            }
        }

        throw new ElementNotFoundException("Елемент не найден.");
    }

    public int length() {
        return stack.length;
    }

    public int getStackSize() {
        return tos + 1;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }
}
