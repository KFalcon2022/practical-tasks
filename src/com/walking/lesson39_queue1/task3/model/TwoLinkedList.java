package com.walking.lesson39_queue1.task3.model;

public class TwoLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public TwoLinkedList(){
        size=0;
    }

    public void add(T value){
        Node<T> temp=new Node<>(value, head, null);
        head=temp;
        size++;
    }
    
}

class Node<E>{
    public E value;
    public Node<E> next;
    public Node<E> previous;

    public Node(E value, Node<E> next, Node<E> previous){
        this.value=value;
        this.next=next;
        this.previous=previous;
    }
}
