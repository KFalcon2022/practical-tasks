package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.structure.BinarySearchTree;

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
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(4);
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(7);
        tree.add(7);
        tree.remove(6);
        tree.remove(10);
        tree.add(8);
        tree.add(1);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.add(12);
        tree.add(13);
        tree.add(14);
        tree.add(15);

        tree.bypassDepth();
        tree.bypassBreadth();

        tree.balance();

        tree.bypassDepth();
        tree.bypassBreadth();
    }
}
