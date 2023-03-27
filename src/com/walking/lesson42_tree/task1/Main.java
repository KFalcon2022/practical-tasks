package com.walking.lesson42_tree.task1;

import java.util.Comparator;

/**
 * Реализуйте бинарное дерево поиска. Учтите возможность использования дерева как для Comparable-сущностей,
 * так и для сортировки на основе компаратора.
 * <p>
 * Реализуйте в рамках дерева методы, производящие обход в глубину (любой из трех рассмотренных в статье) и ширину.
 * Результатом работы этих методов должно быть перечисление элементов дерева в консоли в порядке их обхода.
 * <p>
 * Обратите внимание: в этой задаче не идет речи об автобалансировке дерева.
 * <p>
 * Опциональное условие(*): реализуйте метод балансировки дерева по высоте.
 * В рамках текущей задачи принимается реализация любой степени наивности,
 * если она дает корректный результат.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();

        integerBinaryTree.add(5);
        integerBinaryTree.add(7);
        integerBinaryTree.add(9);
        integerBinaryTree.add(1);
        integerBinaryTree.add(2);
        integerBinaryTree.add(14);
        integerBinaryTree.add(23);
        integerBinaryTree.add(17);
        integerBinaryTree.add(4);

        System.out.println(integerBinaryTree.containsNode(9));

        integerBinaryTree.traverseInDirectOrder(integerBinaryTree.getRoot());
        System.out.println("\n");

        integerBinaryTree.traverseLevelOrder();
        System.out.println("\n");

        integerBinaryTree.delete(7);

        integerBinaryTree.traverseInDirectOrder(integerBinaryTree.getRoot());
        System.out.println("\n");

        integerBinaryTree.traverseLevelOrder();
        System.out.println("\n");

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        BinaryTree<String> stringBinaryTree = new BinaryTree<>(stringComparator);

        stringBinaryTree.add("Monday");
        stringBinaryTree.add("Saturday");
        stringBinaryTree.add("Thursday");
        stringBinaryTree.add("Friday");
        stringBinaryTree.add("Wednesday");
        stringBinaryTree.add("Tuesday");
        stringBinaryTree.add("Sunday");

        stringBinaryTree.traverseInDirectOrder(stringBinaryTree.getRoot());
        System.out.println("\n");

        stringBinaryTree.traverseLevelOrder();
        System.out.println("\n");
    }
}
