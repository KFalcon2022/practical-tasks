package com.walking.lesson42_tree.task2;

import java.util.Comparator;

/**
 * Реализуйте АВЛ-дерево.
 * Сопроводите действия по добавлению (и последующей балансировке)
 * и удалению элементов выводом соответствующих сообщений в консоль.
 */
public class Main {
    public static void main(String[] args) {
        AvlTree<Integer> integerAvlTree = new AvlTree<>();

        integerAvlTree.add(5);
        integerAvlTree.add(7);
        integerAvlTree.add(9);
        integerAvlTree.add(1);
        integerAvlTree.add(2);
        integerAvlTree.add(14);
        integerAvlTree.add(23);
        integerAvlTree.add(17);
        integerAvlTree.add(4);

        System.out.println(integerAvlTree.containsNode(9));

        integerAvlTree.traverseInOrder(integerAvlTree.getRoot());
        System.out.println("\n");

        integerAvlTree.traverseLevelOrder();
        System.out.println("\n");

        integerAvlTree.delete(7);

        integerAvlTree.traverseInOrder(integerAvlTree.getRoot());
        System.out.println("\n");

        integerAvlTree.traverseLevelOrder();
        System.out.println("\n");

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        AvlTree<String> stringAvlTree = new AvlTree<>(stringComparator);

        stringAvlTree.add("Monday");
        stringAvlTree.add("Saturday");
        stringAvlTree.add("Thursday");
        stringAvlTree.add("Friday");
        stringAvlTree.add("Wednesday");
        stringAvlTree.add("Tuesday");
        stringAvlTree.add("Sunday");

        stringAvlTree.traverseInOrder(stringAvlTree.getRoot());
        System.out.println("\n");

        stringAvlTree.traverseLevelOrder();
        System.out.println("\n");
    }
}
