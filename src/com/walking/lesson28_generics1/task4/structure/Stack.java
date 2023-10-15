package com.walking.lesson28_generics1.task4.structure;
import com.walking.lesson28_generics1.task4.exception.ValueNotFoundException;

import java.util.Objects;

public class Stack<T> {
    private Node<T> top;
    private long size;
    public Stack(){};
    public Stack (T top){
        this.top= new Node<>(top);
        size++;
    }
    public long getSize(){
        return size;
    }
    public void add(T value){
        top= new Node<>(value,top);
        size++;
    }
    public void delete(T value) throws ValueNotFoundException{
        Node<T> temp = top;
        if (temp.Value.equals(value)){
            temp=temp.nextValue;
            size--;
            return;
        }
        for (int i=0;i<size-1;i++){

            if (temp.nextValue.Value.equals(value)){
                temp.nextValue=temp.nextValue.nextValue;
                size--;
                return;
            }
            temp=temp.nextValue;
        }
        throw new ValueNotFoundException();
    }
    public T find(T desiredValue){
        Node<T> temp=top;
        while (temp.nextValue!=null){
            if (Objects.equals(temp.Value,desiredValue)){
                return temp.Value;
            }
            temp=temp.nextValue;
        }
        throw new ValueNotFoundException();
    }
    @Override
    public String toString(){
        StringBuilder resultString = new StringBuilder("[");
        Node<T> temp = top;
        while (temp!=null){
            resultString.append(temp.Value);
            if (temp.nextValue!=null){
                resultString.append(", ");
            }
            temp=temp.nextValue;
        }
        resultString.append("]");
        return resultString.toString();
    }

    private static class Node<T>{
        private final T Value;
        private Node<T> nextValue;
        private Node (T value){
            this.Value = value;
        }
        private Node(T value, Node<T> nextValue){
            this.Value = value;
            this.nextValue = nextValue;
        }

    }
}
