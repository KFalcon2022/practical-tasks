package com.walking.lesson39.Test4;

import com.walking.lesson39.Test3.DoubleElement;
import com.walking.lesson39.Test3.MyDoubleList;

public class MyQueue<T> extends MyDoubleList<T> {
    public void push(DoubleElement<T> element){
        addLast(element);
    }

    public DoubleElement<T> poll(){
        DoubleElement<T> element = getFirst();
        if (element != null) {
            head = element.next;
        }
        if (element != null && element.next != null) {
            element.next.prev = null;
        }
        return element;
    }
}
