package com.walking.lesson28_generics1.task4.model;

public class Stack<T> {
    private T value;
    private Stack<T> next;
    private int index;

    public Stack(){
        this.index=1;
    }
    private Stack(T value, int index, Stack<T> stack){
        this.value=value;
        this.index=index;
        this.next=stack;
    }

    public int length(){
        return index;
    }

    public void push(T element){
        if (this.value==null){
            value=element;
        } else{
            this.next=new Stack<T>(this.value, this.index, this.next);
            this.value=element;
            this.index++;
        }
    }

    public T peek(){
        return value;
    }

    public T pop(){
        if (index==1) throw new RuntimeException("This is last element of stack");
        T temp=value;
        this.index=next.index;
        this.value=next.value;
        this.next=next.next;
        return temp;
    }

    public int findElement(T value){
        var temp=this;
        while (temp.next!=null) {
            if(temp.value.equals(value)){
                return temp.index;
            }
            temp=temp.next;
        }
        throw new RuntimeException("Not found");
    }

    public String[] getStrings(){
        String[] s=new String[this.index];
        var temp=this;
        while (temp.next!=null) {
            s[temp.index-1]=temp.value.toString();
            temp=temp.next;
        }
        s[temp.index-1]=temp.value.toString();
        return s;
    }
}
