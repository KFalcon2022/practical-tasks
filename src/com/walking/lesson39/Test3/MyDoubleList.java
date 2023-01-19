package com.walking.lesson39.Test3;

public class MyDoubleList<T> {
    protected DoubleElement<T> head;
    protected DoubleElement<T> tail;

    public MyDoubleList() {
        this.head = null;
        this.tail = null;
    }

    public void addLast(DoubleElement<T> element){
        if (tail != null) {
            tail.next = element;
        }
        element.prev = tail;
        if (head == null){
            head = element;
        }
        tail = element;
    }

    public DoubleElement<T> getFirst(){
        return head;
    }

    protected DoubleElement<T> getLast(){ return tail; }

    public void reverse(){
        if (head == null){
            return;
        }
        DoubleElement<T> element = head;
        while (element != tail){
            DoubleElement<T> temp = element.next;
            element.next = element.prev;
            element.prev = temp;
            element = temp;
        }
        element.next = element.prev;
        element.prev = null;
        DoubleElement<T> temp = head;
        head = tail;
        tail = temp;
    }

    public void removeEvenHashed(){
        if (head == null || head == tail){
            return;
        }

        DoubleElement<T> element = head;
        while (element != null) {
            if (element.hashCode() % 2 == 0){
                if (element.prev != null) {
                    element.prev.next = element.next;
                } else {
                    head = element.next;
                }
                if (element.next != null){
                    element.next.prev = element.prev;
                } else {
                    tail = element.prev;
                }
            }
            element = element.next;
        }
    }
}
