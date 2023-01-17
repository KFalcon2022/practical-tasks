package com.walking.lesson39.task1.list;


import java.util.Objects;

public class SinglyLinkedList<E> {
    int size = 0;
    private final SinglyLinkedList.Node<E> start = new Node<>(null, null);
    private SinglyLinkedList.Node<E> topElement = start;

    public void addElement(E element) {
        Node<E> newNode = new Node<>(null, element);
        topElement.next = newNode;
        topElement = newNode;
        size++;
    }

    /**
     * Removes the first matching element from start.
     * Returns true if element was removed and false if no such element was found in list.
     *
     * @param element element for removing
     */
    public boolean removeElement(E element) {
        Node<E> previousNode = start;
        Node<E> currentNode = start.next;

        Objects.requireNonNull(element);

        while (true) {
            if (currentNode == null) {
                return false;
            } else {
                if (currentNode.item.equals(element)) {
                    previousNode.next = currentNode.next;
                    if (currentNode.equals(topElement)) {
                        topElement = previousNode;
                    }
                    size--;
                    return true;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
        }
    }

    public void reverse() {
        Node<E> currentNode = start.next;
        Node<E> nextNode;
        topElement = currentNode;

        for (int i = 0; i < size; i++) {
            nextNode = currentNode.next;
            currentNode.next = start.next;
            start.next = currentNode;
            currentNode = nextNode;
        }

        topElement.next = null;
    }

    public void deleteNodesWhereHashIsEven() {
        Node<E> currentNode = start.next;
        start.next = null;
        topElement = start;
        int oldSize = size;
        size = 0;

        for (int i = 0; i < oldSize; i++) {
            if (currentNode.item.hashCode() % 2 != 0) {
                topElement.next = currentNode;
                topElement = currentNode;
                size++;
            }
            currentNode = currentNode.next;
        }
    }

    public SinglyLinkedList.Node<E> getTop() {
        return topElement;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        Node<E> currentNode = start.next;
        StringBuilder result = new StringBuilder();
        while (currentNode != null) {
            result.append(currentNode).append(" ");
            currentNode = currentNode.next;
        }

        return result.toString();
    }

    private static class Node<E> {

        private SinglyLinkedList.Node<E> next;
        private final E item;

        Node(SinglyLinkedList.Node<E> next, E item) {
            this.item = item;
            this.next = next;
        }

        //Чисто для себя, чтобы видеть хеш)
        @Override
        public String toString() {
            return item == null ? "start" : item + " (hash = " + item.hashCode() + ")";
        }
    }
}
