package com.walking.lesson39_queue1.task4.model;

import com.walking.lesson39_queue1.task3.model.TwoLinkedList;

public class Queue<T> {
    private TwoLinkedList<T> list=new TwoLinkedList<>();

    public T pop(){
        return list.delFirst();
    }

    public void push(T value){
        list.addLast(value);
    }

    public T peek(){
        return list.getValueByIndex(1);
    }

    public int size(){
        return list.getSize();
    }
}
