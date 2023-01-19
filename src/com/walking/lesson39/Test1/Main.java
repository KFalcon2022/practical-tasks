package com.walking.lesson39.Test1;

public class Main {
    public static void main(String[] args){
        MyList<String> myList = new MyList<>();

        // Небезопасный метод. Первый элемент пустого списка null
        //System.out.println(myList.getFirst().data);

        myList.addLast(new Element("First"));
        myList.addLast(new Element("Second"));
        myList.addLast(new Element("Third"));

        System.out.println("\nПервый элемент списка");
        System.out.println(myList.getFirst().data);

        printList(myList, "\nУбедимся, что оно работает как список");

        myList.reverse();

        System.out.println("\nПервый элемент развернутого списка");
        System.out.println(myList.getFirst().data);

        printList(myList, "\nНу и просто проверим, что оно работает как список");

        myList.addLast(new Element("Fourth"));
        myList.addLast(new Element("Fifth"));

        printList(myList, "\nБольше тестов");

        myList.reverse();
        printList(myList, "\nЕще больше тестов");

        myList.removeEvenHashed();
        printList(myList, "\nСписок с удаленныим четными хэшами");
    }

    public static void printList(MyList<String> myList, String description){
        System.out.println(description);
        Element<String> e = myList.getFirst();
        int number = 0;
        while (e != null){
            System.out.println("%d - %s".formatted(number, e.data));
            e = e.next;
            number ++;
        }
    }
}
