package com.walking.lesson28.Task4;

import java.lang.reflect.Array;

public class Stack<T> {
    private final T[] values;
    private final int size;
    private int head;

    public Stack(Class T, int size){
        this.size = size;
        this.values = (T[]) Array.newInstance(T, size);
        this.head = 0;
    }

    public Stack<T> push(T value){
        try {
            values[head++] = value;
        } catch (IndexOutOfBoundsException e) {
            System.out.print(e);
        }
        return this;
    }

    public T pop(){
        //Пусть будет тупо исключение по факту, если уж так в задании сказано :-)
        return values[--head];
        /*
        try {
            return values[--head];
        } catch (IndexOutOfBoundsException e) {
            System.out.print(e);
        }*/
    }

    public int getDepth(){
        return head;
    }

    public T find(T needle){
        for (int i=0; i<head; i++) {
            if (values[i].equals(needle)) {
                return values[i];
            }
        }
        throw new RuntimeException(needle + " Not Found");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<head; i++) {
            sb.append(values[i].toString());
            if (i < head-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
