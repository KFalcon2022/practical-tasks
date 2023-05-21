package com.walking.lesson28_generics1.task4.model;

public class Element<T extends Object> {
    private final T current;

    private Element<T> next;

    public Element(T current, Element<T> next) {
        this.current = current;
        this.next = next;
    }

    public Element<T> getNext() {
        return next;
    }

    public T getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return this.current.toString();
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }
}
