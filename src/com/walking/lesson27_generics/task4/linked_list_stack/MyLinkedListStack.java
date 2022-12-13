package com.walking.lesson27_generics.task4.linked_list_stack;

import com.walking.lesson27_generics.task4.exceptions.EmptyStackException;

import java.util.NoSuchElementException;

public class MyLinkedListStack<E> {

    int size = 0;
    private Node<E> topElement = new Node<>(null, null, null);

    public void addElement(E element) {
        Node<E> newItem = new Node<>(topElement, null, element);
        topElement.next = newItem;
        topElement = newItem;
        size++;
    }

    //Delete element from top of a stack
    public void deleteElement() throws EmptyStackException {
        if (size > 0) {
            topElement = topElement.prev;
            topElement.next = null;
            size--;
        } else {
            throw new EmptyStackException("Stack is empty");
        }
    }

    //Delete element from top of a stack
    public void deleteGivenElement(E item) {
        Node<E> forDelete = search(topElement, item);
        forDelete.prev.next = forDelete.next;
        forDelete.next.prev = forDelete.prev;
        size--;
    }

    public E findElement(E item) {
        Node<E> search = search(topElement, item);

        return search.item;
    }

    private Node<E> search(Node<E> node, E element) {
        if (node.prev == null) {
            throw new NoSuchElementException(String.format("Element %s not found", element));
        }

        if (element.equals(node.item)) {
            return node;
        }

        return search(node.prev, element);
    }

    public Node<E> getTop() {
        return topElement;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[")
                .append(topElement.toString())
                .append("]");

        return result.toString();
    }

    private static class Node<E> {

        private Node<E> prev;
        private Node<E> next;
        private final E item;

        Node(Node<E> prev, Node<E> next, E item) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            if (item != null) {
                result.append("{")
                        .append(item)
                        .append("}");
                if (prev.item != null) {
                    result.append(", ");
                }
                result.append(prev);

            }

            return result.toString();
        }
    }
}
