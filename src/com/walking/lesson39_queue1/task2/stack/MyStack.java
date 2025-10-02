package com.walking.lesson39_queue1.task2.stack;

import com.walking.lesson39_queue1.task1.list.MyList;

public class MyStack<E> {
    private final MyList<E> list;

    public MyStack(E el) {
        this.list = new MyList<>(el);
    }

    public MyStack() {
        this.list = new MyList<>();
    }

    public Object peek() {
        return list.getTailValue();
    }

    public void push(E el) {
        list.add(el);
    }

    public Object pop() {
        Object del = list.getTailValue();
        list.remove(del);
        return del;
    }
}
