package com.walking.lesson28_generics1.task4.structure;
import com.walking.lesson28_generics1.task4.exception.ValueNotFoundException;

import java.util.Objects;

public class Stack<T>{
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
        if (top.value.equals(value)){
            top=top.nextValue;
            size--;
            return;
        }
        Node<T> tempNode=top;
        for (int i=0;i<size-1;i++){

            if (tempNode.nextValue.value.equals(value)){
                tempNode.nextValue=tempNode.nextValue.nextValue;
                size--;
                return;
            }
            tempNode=tempNode.nextValue;
        }
        throw new ValueNotFoundException();
    }
    public T find(T desiredValue){
        Node<T> temp=top;
        while (temp.nextValue!=null){
            if (Objects.equals(temp.value,desiredValue)){
                return temp.value;
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
            resultString.append(temp.value);
            if (temp.nextValue!=null){
                resultString.append(", ");
            }
            temp=temp.nextValue;
        }
        resultString.append("]");
        return resultString.toString();
    }

    private static class Node<T>{
        private final T value;
        private Node<T> nextValue;
        private Node (T value){
            this.value = value;
        }
        private Node(T value, Node<T> nextValue){
            this.value = value;
            this.nextValue = nextValue;
        }
    }

    public Stack<T> reverseList(){
        Stack<T> resultStack = new Stack<>();
        Node<T> tempNode = top;
        while (tempNode!=null){
            resultStack.add(tempNode.value);
            tempNode=tempNode.nextValue;
        }
        return resultStack;
    }

    public void deleteOddNodes(){
        //метод, удаляющий все узлы, хэшкод элемента которых - четный.
        Node<T> tempNode=top;
        while (tempNode!=null){
            if (tempNode.value.hashCode()%2==0){
                System.out.println("Value "+tempNode.value+" has hashcode "+tempNode.value.hashCode());
                delete(tempNode.value);
            }
            tempNode=tempNode.nextValue;
        }
    }

    public T getTop(){
        return top.value;
    }

}
