package com.walking.lesson39_queue1.collections;

public class OneEndQueue<T> {
    private final DoublyLinkedList<T> list;
    public OneEndQueue(){
        this.list = new DoublyLinkedList<>();
    }

    //Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    public T peek(){
        return list.getTop();
    }
    //Retrieves and removes the head of this queue, or returns null if this queue is empty.
    public T poll(){
        T result=list.getTop();
        list.remove(result);
        return result;
    }
    //Retrieves and removes the head of this queue.
    public void remove(){
        list.remove(list.getTop());
    }
    public void add(T value){
        list.add(value);
    }
    @Override
    public String toString(){
        return list.toString();
    }
}
