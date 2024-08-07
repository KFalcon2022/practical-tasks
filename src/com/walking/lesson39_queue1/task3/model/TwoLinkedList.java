package com.walking.lesson39_queue1.task3.model;

import java.util.Iterator;

public class TwoLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int getSize() {
        return size;
    }

    public TwoLinkedList(){
        size=0;
    }

    public void addFirst(T value){
        Node<T> temp=new Node<>(value, head, null);
        if (size!=0)
            head.previous=temp;
        if (size==0)
            tail=temp;
        // if (size==1)
        //     tail.previous=temp;
        head=temp;
        size++;
    }

    public void addLast(T value){
        Node<T> temp=new Node<>(value, null, tail);
        if (size!=0)
            tail.next=temp;
        if (size==0)
            head=temp;
        // if (size==1)
        //     head.next=temp;
        tail=temp;
        size++;
    }
    
    public boolean addToIndex(T value, int index){
        if (size==0){
            if (index==1){
                addFirst(value);
                return true;
            } else {
                return false;
            }
        }

        if (index<1|index>size)
            return false;
        
        Node<T> tempNode=head;
        for (int i = 1; i <=size; i++) {
            if (i==index){
                shift(tempNode, value);
                size++;
                break;
            }
            tempNode=tempNode.next;            
        }
        return true;
    }

    public int getIndexByValue(T value){
        int i=1;
        for (T  element : this) {
            if (value.equals(element))
                return i;
            i++;
        }
        return -1;
    }

    public T getValueByIndex(int index){
        if (index<1|index>size)
            return null;
        int i=1;
        for (T element : this) {
            if (i==index)
                return element;
            i++;
        }
        return null;
    }

    public T delFirst(){
        if (size==0)
            return null;
        T value=head.value;
        head=head.next;
        if (size!=1)
            head.previous=null;
        size--;
        if (size==0)
            tail=null;
        return value;
    }

    public T delLast(){        
        if (size==0)
            return null;
        T value=tail.value;
        tail=tail.previous;
        if (size!=1)
            tail.next=null;
        size--;
        if (size==0)
            head=null;
        return value;
    }

    public T delByIndex(int index){
        if (index<1|index>size)
            return null;
        if (index==1)
            return delFirst();
        if (index==size)
            return delLast();
        Node<T> nodeToDelete=head.next;
        for (int i = 2; i < size; i++) {
            if (index==i)
                return del(nodeToDelete);           
        }
        return null;
    }

    public int delByValue(T value){
        Node<T> nodeToDelete=head;
        for (int i = 1; i <= size; i++) {
            if (nodeToDelete.value.equals(value)){
                if (i==1){
                    delFirst();
                } else if (i==size){
                    delLast();
                } else {
                    del(nodeToDelete);
                }                  
                return i;
            }        
            nodeToDelete=nodeToDelete.next;
        }
        return -1;
    }

    public void roll(){
        if (size==0|size==1)
            return;
        Node<T> fromTail=tail;
        Node<T> fromHead=head;
        T temp;
        int n;
        if (size%2==0){
            n=size/2;
        } else {
            n=(size-1)/2;
        }
        for (int i = 1; i <=n; i++) {
            temp=fromHead.value;
            fromHead.value=fromTail.value;
            fromTail.value=temp;
            fromHead=fromHead.next;
            fromTail=fromTail.previous;
        }
    }

    public boolean delEvenHashcode(){
        boolean change=false;
        Node<T> nodeToDelete=head;
        while (nodeToDelete!=null) {
            if (nodeToDelete.value.hashCode()%2==0){
                if (nodeToDelete==head){
                    delFirst();
                } else if (nodeToDelete==tail){
                    delLast();
                } else {
                    del(nodeToDelete);
                }                 
                change=true; 
            }        
            nodeToDelete=nodeToDelete.next;
        }
        return change;
    }

    private T del(Node<T> nodeToDelete){
        nodeToDelete.previous.next=nodeToDelete.next;
        nodeToDelete.next.previous=nodeToDelete.previous;
        size--;
        T value=nodeToDelete.value;
        nodeToDelete=null;
        return value;
    }

    private void shift(Node<T> tempNode, T value){
        Node<T> newNode=new Node<>(value, tempNode, tempNode.previous);
        if (newNode.previous!=null){
            newNode.previous.next=newNode;
        } else {
            head=newNode;
        }
        tempNode.previous=newNode;
    }

    public Iterator<T> iterator() {      
        Iterator<T> it=new Iterator<T>(){
            Node<T> node=head;
            @Override
            public boolean hasNext(){
                return node!=null;
            }

            @Override
            public T next() {
                T value=node.value;
                node=node.next;
                return value;
            }
        };
        return it;
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
