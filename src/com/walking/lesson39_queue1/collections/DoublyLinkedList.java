package com.walking.lesson39_queue1.collections;

// Для разнообразия реализуем по методу FIFO

import java.util.*;

public class DoublyLinkedList<T> implements Collection<T> {
    private Node<T> top;
    private Node<T> bottom;
    private long size;
    public DoublyLinkedList(){};
    public DoublyLinkedList(T value){
        this.bottom=new Node<>(value,null,null);
        size++;
    }

    @Override
    public int size() {
        return (int) size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> temp=bottom;

        while (temp!=null){
            if (Objects.equals(o,temp.value)){
                return true;
            }
            temp=temp.previousNode;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedLissIterator<>(bottom);
    }

    @Override
    public Object[] toArray() {
        Node<T> temp=bottom;
        Object[] resultArray=new Object[(int)size];
        int index=0;

        while (temp!=null){
            resultArray[index]=temp.value;
            temp=temp.previousNode;
            index++;
        }
        return resultArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return ((T1[]) Arrays.copyOf(toArray(),(int)size,a.getClass()));
    }

    public boolean add(T value){
        if (bottom==null){
            this.bottom=new Node<>(value,null,null);
            size++;
            return true;
        }
        if (top==null){
            this.top=new Node<>(value,bottom,null);
            bottom.previousNode =top;
            size++;
            return true;
        }
        this.top=new Node<>(value,top,null);
        //установка ссылки на новую вершину после добавления нового элемента
        top.nextNode.previousNode =top;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> temp=bottom;

        if (Objects.equals(o,bottom.value)){
            bottom=bottom.previousNode;
            bottom.nextNode=null;
            size--;
            return true;
        }
        if (Objects.equals(o,top.value)){
            top=top.nextNode;
            top.previousNode=null;
            size--;
            return true;
        }

        while(temp.previousNode!=null){
            if (Objects.equals(o,temp.value)){
                temp.nextNode.previousNode=temp.previousNode;
                temp.previousNode.nextNode=temp.nextNode;
                size--;
                return true;
            }
            temp=temp.previousNode;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c){
            if (!contains(item)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item:c){
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object item : c){
            if (remove(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Node<T> temp=bottom;
        boolean flag=false;

        while (temp!=null){
            if (!c.contains(temp.value)){
                remove(temp.value);
                flag=true;
            }
            temp=temp.previousNode;
        }
        return flag;
    }

    @Override
    public void clear() {
        bottom=null;
        top=null;
        size=0;
    }

    @Override
    public String toString(){
        // по умолчанию FIFO
        StringBuilder resultString = new StringBuilder("[");
        Node<T> temp=bottom;
        while (temp!=null){
            resultString.append(temp.value);
            if (temp.previousNode !=null){
                resultString.append(", ");
            }
            temp=temp.previousNode;
        }
        resultString.append("]");
        return resultString.toString();
    }
    public String toStringLIFO(){
        StringBuilder resultString = new StringBuilder("[");
        Node<T> temp = top;
        while (temp != null) {
            resultString.append(temp.value);
            if (temp.nextNode != null) {
                resultString.append(", ");
            }
            temp = temp.nextNode;
        }
        resultString.append("]");
        return resultString.toString();
    }
    private static class DoublyLinkedLissIterator<T> implements Iterator<T>{
        private Node<T> current;
        public DoublyLinkedLissIterator(Node<T> bottom){
            this.current=bottom;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            T result = current.value;
            current=current.previousNode;
            return result;
        }
    }
    public T getTop(){
        return top.value;
    }
    public T getBottom(){
        return bottom.value;
    }


    private static class Node<T>{
        private final T value;
        private Node<T> nextNode;
        private Node<T> previousNode;
        private Node (T value){
            this.value=value;
        }
        private Node (T value, Node<T> nextNode, Node<T> previousNode){
            this.value=value;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }
    }
}
