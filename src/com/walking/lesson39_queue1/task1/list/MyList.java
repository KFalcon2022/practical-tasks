package com.walking.lesson39_queue1.task1.list;

import com.walking.lesson39_queue1.task1.exception.ElementNotFoundException;

import java.util.Objects;

public class MyList<E> {
    private Element<E> tail;
    int size;

    public MyList() {
    }

    public MyList(E top) {
        this.tail = new Element<>(top);
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object find(Object o) {
        Element<E> el = tail;

        while (el != null) {
            if (o.equals(el.value)) {
                return el.value;
            }
            el = el.previous;
        }
        throw new ElementNotFoundException("Элемент не найден.");
    }

    public boolean add(E el) {
        tail = new Element<>(tail, el);
        size++;
        return true;
    }

    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }

        if (o.equals(tail.value)) {
            tail = tail.previous;
            size--;
            return true;
        }

        Element<E> el = tail;
        while (el.previous != null) {
            if (o.equals(el.previous.value)) {
                el.previous = el.previous.previous;
                size--;
                return true;
            }
            el = el.previous;
        }
        return false;
    }

    public String toString() {
        StringBuilder allElements = new StringBuilder();
        Element<E> el = tail;

        while (el != null) {
            allElements.append(el.value);
            if (el.previous != null) {
                allElements.append(", ");
            }
            el = el.previous;
        }
        return allElements.toString();
    }

    public void reverse() {
        Element<E> prev = null;
        Element<E> top = tail;

        while (top != null) {
            Element<E> newTail = top.previous;
            top.previous = prev;
            prev = top;
            top = newTail;
        }

        tail = prev;
    }

    public void removeEvenHashCodes() {
        while (!isEmpty() && tail.hashCode() % 2 == 0) {
            tail = tail.previous;
            size--;
        }

        Element<E> current = tail;
        while (current.previous != null) {
            if (current.previous.hashCode() % 2 == 0) {
                current.previous = current.previous.previous;
                size--;
            } else {
                current = current.previous;
            }
        }
    }

    public Object getTailValue() {
        return tail.value;
    }

    private static class Element<E> {
        private final E value;
        private Element<E> previous;

        private Element(E value) {
            this.value = value;
        }

        private Element(Element<E> previous, E value) {
            this.value = value;
            this.previous = previous;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, previous);
        }
    }
}
