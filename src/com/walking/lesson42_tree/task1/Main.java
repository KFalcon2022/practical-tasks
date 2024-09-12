package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.Structure.BinaryTree;

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
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);

        System.out.println(tree.isEmpty());

        tree.remove(1);
        tree.remove(2);
        tree.remove(3);

        System.out.println(tree.getRoot().getValue());
    }
}
