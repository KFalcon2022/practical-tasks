package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.model.MyTree;

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
        MyTree<Integer> tree = new MyTree<>();
        tree.add(41);
        tree.add(4);
        tree.add(16);
        tree.add(25);
        tree.add(35);
        tree.add(47);
        tree.add(56);
        tree.add(68);
        tree.add(76);
        tree.add(10);
        tree.add(30);
        tree.add(52);
        tree.add(73);
        tree.add(20);
        tree.add(60);

        System.out.println("Size: " + tree.getSize());
        tree.walkDeep(tree.getRoot());

        tree.remove(30);
        System.out.println("Size: " + tree.getSize());

        tree.walkWidth(tree.getRoot());

        System.out.println();
    }
}
