package com.walking.lesson42.Task1;

import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        MyTree<Integer> tree = new MyTree<>(Comparator.comparing(Integer::valueOf));
        tree.add(15);
        tree.add(16);
        tree.add(8);
        tree.add(36);
        tree.add(0);
        tree.add(54);

        tree.walkPrint(); // Да я знаю что это не зона ответственности дерева
        tree.widePrint(); // Обход в ширину

        System.out.println("searching 8 - " + tree.search(8));
        System.out.println("searching 36 - " + tree.search(36));
        System.out.println("searching 19 - " + tree.search(19));

        tree.remove(8);
        tree.remove(36);
        tree.widePrint();
    }
}
