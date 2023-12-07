package com.walking.lesson39_queue1.task2.collection;

import com.walking.lesson28_generics1.task4.structure.Stack;

public class StackTrue<T> {
    private final Stack<T> list = new Stack<>();
    public void push(T element){
        list.add(element);
        System.out.println(element+" was added to stack!");
    }
    public T pop(){
        T result = list.getTop();
        list.delete(result);

        return result;
    }
    @Override
    public String toString(){
        return list.toString();
    }
}
