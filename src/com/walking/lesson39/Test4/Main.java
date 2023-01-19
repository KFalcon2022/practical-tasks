package com.walking.lesson39.Test4;

import com.walking.lesson39.Test3.DoubleElement;
import com.walking.lesson39.Test3.MyDoubleList;

public class Main {
    public static void main(String[] args){
        MyQueue<String> myQueue = new MyQueue<>();

        myQueue.push(new DoubleElement("First"));
        myQueue.push(new DoubleElement("Second"));
        myQueue.push(new DoubleElement("Third"));

        printQueue(myQueue, "\nОчистка");
        printQueue(myQueue, "\nПустое");
    }

    public static void printQueue(MyQueue<String> myDoubleList, String description){
        System.out.println(description);
        DoubleElement<String> e = null;
        int number = 0;
        while ((e = myDoubleList.poll()) != null){
            System.out.println("%d - %s".formatted(number, e.data));
            number ++;
        }
    }
}