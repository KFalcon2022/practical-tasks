package com.walking.lesson39.Test3;

public class Main {
    public static void main(String[] args){
        MyDoubleList<String> myDoubleList = new MyDoubleList<>();

        myDoubleList.addLast(new DoubleElement("First"));
        myDoubleList.addLast(new DoubleElement("Second"));
        myDoubleList.addLast(new DoubleElement("Third"));

        printList(myDoubleList, "\nУбедимся, что оно работает как список");

        myDoubleList.addLast(new DoubleElement("Forths"));
        myDoubleList.addLast(new DoubleElement("Fifths"));
        myDoubleList.reverse();
        printList(myDoubleList, "\nРазворот");

        myDoubleList.removeEvenHashed();
        printList(myDoubleList, "\nОчистка");

    }

    public static void printList(MyDoubleList<String> myDoubleList, String description){
        System.out.println(description);
        DoubleElement<String> e = myDoubleList.getFirst();
        int number = 0;
        while (e != null){
            System.out.println("%d - %s".formatted(number, e.data));
            e = e.next;
            number ++;
        }
    }
}
