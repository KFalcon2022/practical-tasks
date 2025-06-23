package com.walking.lesson39_queue1.task4.structure;

import com.walking.lesson39_queue1.task4.exception.ElementNotFoundException;

import java.util.StringJoiner;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
    }

    public LinkedList(E element) {
        this.first = new Node<>(element);
        this.last = first;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new ElementNotFoundException();
        }

        return first.value;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new ElementNotFoundException();
        }

        return last.value;
    }

    public void addFirst(E element) {
        first = new Node<E>(element, first, null);

        if (first.isLast()) {
            last = first;
        } else {
            first.next.previous = first;
        }

        size++;
    }

    public void addLast(E element) {
        last = new Node<E>(element, null, last);

        if (last.isFirst()) {
            first = last;
        } else {
            last.previous.next = last;
        }

        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new ElementNotFoundException();
        }

        E result = getFirst();
        delete(first);

        return result;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new ElementNotFoundException();
        }

        E result = getLast();
        delete(last);

        return result;
    }

    public void reverse() {
        if (isReversible()) {
            Node<E> current = first;

            while (current != null) {
                current.swapNextAndPrevious();
                current = current.previous;
            }

            swapFistAndLast();
        }
    }

    public void deleteAllWithEvenHash() {
        Node<E> current = first;

        while (current != null) {
            if (current.hasEvenHash()) {
                delete(current);
            }

            current = current.next;
        }
    }

    private boolean isReversible() {
        return size > 1;
    }

    private void swapFistAndLast() {
        Node<E> temp = first;
        first = last;
        last = temp;
    }

    private void delete(Node<E> current) {
        if (current.isFirst()) {
            first = first.next;
        } else {
            current.previous.next = current.next;
        }

        if (current.isLast()) {
            last = last.previous;
        } else {
            current.next.previous = current.previous;
        }

        size--;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner("] <> [", "first-> [", "] <-last");
        Node<E> current = first;

        while (current != null) {
            result.add(current.value.toString());
            current = current.next;
        }

        return result.toString();
    }

    private static class Node<E> {
        private final E value;
        private Node<E> next;
        private Node<E> previous;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        private boolean isFirst() {
            return previous == null;
        }

        private boolean isLast() {
            return next == null;
        }

        private boolean hasEvenHash() {
            return value.hashCode() % 2 == 0;
        }

        private void swapNextAndPrevious() {
            Node<E> temp = next;
            next = previous;
            previous = temp;
        }
    }
}