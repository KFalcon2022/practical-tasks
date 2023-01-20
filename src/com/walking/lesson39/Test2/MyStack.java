package com.walking.lesson39.Test2;
/*
import com.walking.lesson39.Test1.Element;
import com.walking.lesson39.Test1.MyList;

public class MyStack<T> extends MyList<T> {
    public void push(Element<T> element){
        addLast(element);
    }

    public Element<T> pop(){
        Element<T> e = head;
        Element<T> prev = null;
        while (e != null && e.next != null){
            prev = e;
            e = e.next;
        }
        if (prev == null){
            head = null;
        } else {
            prev.next = null;
        }
        return e;
    }

    public MyStack<T> reversed(){
        MyStack<T> stack = new MyStack<>();
        Element<T> e = null;
        while ((e = pop()) != null){
            stack.push(e);
        }
        return stack;
    }
}
*/