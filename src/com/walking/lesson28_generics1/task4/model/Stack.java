package com.walking.lesson28_generics1.task4.model;

import com.walking.lesson28_generics1.task4.exception.ElementNotFoundException;

import java.util.Objects;

public class Stack<E> {
    private final Object[] elements;
    private int currentElement;

    public Stack() {
        elements = new Object[5];
    }

    public int size() {
        return currentElement;
    }

    public void push(E addElement) {
        if (currentElement < elements.length) {
            elements[currentElement++] = addElement;
        } else {
            throw new RuntimeException("Stack overflow!");
        }
    }

    public E delete(E deletedElement) {
        E foundElement = null;
        int indexFoundElement = -1;

        for (int i = currentElement - 1; i >= 0; i--) {
            if (Objects.equals(elements[i], deletedElement)) {
                foundElement = (E) elements[i];
                indexFoundElement = i;
                break;
            }
        }

        if (indexFoundElement != -1) {
            for (int i = indexFoundElement; i < currentElement - 1; i++) {
                elements[i] = elements[i + 1];
            }

            elements[currentElement - 1] = null;
            currentElement--;
            return foundElement;
        } else {
            throw new ElementNotFoundException("невозможно удалить несуществующий элемент");
        }
    }


    public E find(E searchedElement) {
        for (int i = currentElement - 1; i >= 0; i--) {
            if (Objects.equals(elements[i], searchedElement)) {
                return (E) elements[i];
            }
        }

        throw new ElementNotFoundException("Элемент не найден");
    }

    @Override
    public String toString() {
        //через StringBuilder нужно дополнительно вручную обработать конец строки,но
        //не создаются лишние объекты String в цикле
        StringBuilder sb = new StringBuilder("([");

        for (int i = 0; i < currentElement; i++) {
            sb.append(elements[i]).append(", ");
        }

        sb.replace(sb.length() - 2, sb.length(), "])");

        return sb.toString();
//
//        //через StringJoiner чуть проще код, но создаются лишние объекты String в цикле
//        StringJoiner stringJoiner = new StringJoiner(",", "([", "])");
//
//        for (int i = 0; i < currentElement; i++) {
//            stringJoiner.add(elements[i].toString());
//        }
//
//        return stringJoiner.toString();
    }
}
