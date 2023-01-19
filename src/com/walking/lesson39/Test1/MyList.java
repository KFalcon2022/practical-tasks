package com.walking.lesson39.Test1;

public class MyList<T> {
    protected Element<T> head; // Наверное было бы красивее использовать какой-то спец. нулевой Element в качестве головы

    public MyList() {
        this.head = null;
    }

    public void addLast(Element<T> element){
        if (head == null){
            head = element;
        } else {
            getLast().next = element;
        }
    }

    public Element<T> getFirst(){
        return head;
    }

    protected Element<T> getLast(){
        Element<T> e = head;
        while (e != null && e.next != null){
            e = e.next;
        }
        return e;
    }

    public void reverse(){
        if (head == null){
            return;
        }
        Element<T> prevElement = head;
        Element<T> nextElement = prevElement.next;
        prevElement.next = null; // сделать первый последним
        while (nextElement != null){
            Element<T> temp = nextElement.next;
            nextElement.next = prevElement;
            prevElement = nextElement;
            head = nextElement;
            nextElement = temp;
        }
    }

    public void removeEvenHashed(){
        if (head == null){
            return;
        }
        Element<T> element = head;
        Element<T> prevElement = null;
        while (element != null) {
            if (element.hashCode() % 2 == 0){
                // первый
                if (head == element){
                    head = element.next;
                }
                // последний
                else if (element.next == null){
                    if (prevElement != null) {
                        prevElement.next = null;
                    }
                }
                // все остальные
                else {
                    prevElement.next = element.next;
                }
            } else {
                prevElement = element;
            }
            element = element.next;
        }
    }
}
