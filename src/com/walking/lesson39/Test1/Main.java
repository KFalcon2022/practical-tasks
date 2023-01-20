package com.walking.lesson39.Test1;

public class Main {
    public static void main(String[] args){
        MyList<String> myList = new MyList<>();

        myList.add("First");
        myList.add("Second");
        myList.add("Third");
        printList(myList, "\nУбедимся, что оно работает как список");

        myList.reverse();
        printList(myList, "\nНу и просто проверим, что оно всё ещё работает как список");

        myList.add("Fourth");
        myList.add("Fifth");
        printList(myList, "\nБольше тестов");

        myList.reverse();
        printList(myList, "\nЕще больше тестов");

        myList.filter(e -> e.hashCode() % 2 == 0);
        printList(myList, "\nСписок с удаленными четными хэшами");

        // теоретически, можно было сделать, чтоб filter и reversed возвращали новый MyList
    }

    public static void printList(MyList<String> myList, String description){
        System.out.println(description);
        MyList<String>.Node<String> node = myList.getFirstNode();
        int number = 0;
        while (node != null){
            System.out.println("%d - %s".formatted(number, node.data));
            node = node.next;
            number ++;
        }
    }
}
