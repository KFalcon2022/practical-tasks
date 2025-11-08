package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.tree.BinaryTree;


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
        BinaryTree<Integer> numbs = new BinaryTree<>();
        numbs.add(32);
        numbs.add(46);
        numbs.add(17);
        numbs.add(10);
        numbs.add(23);
        numbs.add(56);
        numbs.add(54);
        numbs.add(55);
        numbs.add(47);
        numbs.add(73);
        numbs.add(64);

        numbs.delete(56);
        numbs.add(87);

        System.out.println(numbs.searchPreorder());

        numbs.balance();

        System.out.println(numbs.searchPreorder());
        System.out.println(numbs.searchBreadthFirst());
    }
}
