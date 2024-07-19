package com.walking.lesson39_queue1.task1.model;

import java.util.EmptyStackException;

public class RollebleStack<T> {

    private Node<T> head;
    private int size;

    public int size(){
        return size;
    }

    public RollebleStack(){
        size=0;
    }

    public T push(T value){
        Node<T> newNode=new Node<>(value, head);
        head=newNode;
        size++;
        return peek();
    }

    public T peek(){
        if (!isEmpty())
            return head.value;
        throw new EmptyStackException();
    }

    public T pop(){     
        if (!isEmpty()){
            T result=peek();
            head=head.next;
            size--;
            return result;
        }
        throw new EmptyStackException();    
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void roll(){
        RollebleStack<T> newStack=new RollebleStack<>();
        while (!isEmpty()) {
            newStack.push(pop());
        }
        this.head=newStack.head;
        this.size=newStack.size;
    }

    public void delEvenHash(){
        roll();
        RollebleStack<T> newStack=new RollebleStack<>();
        while (!isEmpty()) {
            if (peek().hashCode()%2!=0){
                newStack.push(pop());
            } else {
                pop();
            }
        }
        this.head=newStack.head;
        this.size=newStack.size;
    }

    public T getValueByIndex(int index){
        if (index>size){
            throw new NullPointerException();
        }
        Node<T> temp=head;
        for (int i = 1; i <index; i++) {
            temp=temp.next;
        }
        return temp.value;
    }

    @Override
    public String toString(){
        StringBuilder s=new StringBuilder();
        Node<T> temp=head;
        while (temp.next!=null) {
            s.append(temp.value.toString()+"\n");
            temp=temp.next;
        }
        s.append(temp.value.toString()+"\n");
        return s.toString();
    }
}
class Node<E> {
    public E value;
    public Node<E> next;   
    public Node(E value, Node<E> next){
        this.value=value;
        this.next=next;
    }
}