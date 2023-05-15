package com.walking.lesson28_generics1.task4;

public class Srtack <T> {
    private T[] data;
    private int size;
    public Srtack(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void push(T value){
        if(size == data.length){
            resize(2 * data.length);
        }
        data[size++] = value;
    }

    private void resize(int i) {
        T[] newData = (T[]) new Object[i];
        for (int j = 0; j < size; j++) {
            newData[j] = data[j];
        }
        data = newData;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        T value = data[--size];
        data[size] = null;
        if(size > 0 && size == data.length / 4){
            resize(data.length / 2);
        }
        return value;
    }
}
