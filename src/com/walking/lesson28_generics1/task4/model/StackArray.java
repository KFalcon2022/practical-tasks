package com.walking.lesson28_generics1.task4.model;
//Наработки стека, до того как я понял, что его нужно делать без массива.
//Зато реализовал сам для себя динамический массив.
public class StackArray<T>{
    private class StackElement<S>{
        public S value;
        public StackElement<S> nextElement;
    }
    private StackElement<T>[] stack;
    private StackElement<T> head;
    private int index=0;

    public StackArray(){
        this.stack=new StackElement[10];
    }
    public T pop(){
        if (head==null) throw new RuntimeException("Stack is empty");
        StackElement<T> oldHead=head;
        index--;
        head=stack[index];
        return oldHead.value;
        
    }

    public int length(){
        return index+1;
    }

    public T peek(){
        if (head==null) throw new RuntimeException("Stack is empty");
        return head.value;
    }

    public void push(T newElement){
        if (head==null){//Добавление первого элемента
            stack[index].value=newElement;
            head=stack[index];
        } else{
            index++;
            checkLength();
            stack[index].value=newElement;
            stack[index].nextElement=stack[index-1];
            head=stack[index];
        }

    }

    private void checkLength(){
        if (index==stack.length){
            StackElement<T>[] temp=new StackElement[(int)(index*1.5)];
            for (int i=0; i<=index-1; i++){
                temp[i]=stack[i];
            }
            stack=temp;
        }
    }

    
}