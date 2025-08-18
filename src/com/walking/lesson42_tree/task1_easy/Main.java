package com.walking.lesson42_tree.task1_easy;

import com.walking.lesson42_tree.task1_easy.structure.UnbalancedBinaryTree;

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
        UnbalancedBinaryTree<Integer> tree = new UnbalancedBinaryTree<>();

        tree.add(30);
        tree.add(57);
        tree.add(18);
        tree.add(65);
        tree.add(40);
        tree.add(9);
        tree.add(96);
        tree.add(24);
        tree.add(12);
        tree.add(98);
        tree.add(62);
        tree.add(55);
        tree.add(31);
        tree.add(20);

//        tree.delete(40);
//        tree.straightBypass();

//        tree.printReverseTree();

//        tree.middlePrintTree();

        tree.widthBypass();
    }
}
