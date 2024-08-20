package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.model.BinSearchTree;

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
        BinSearchTree<Integer> tree=new BinSearchTree<>();
        tree.add(50);
        tree.add(60);
        tree.add(30);
        tree.add(40);
        tree.add(20);
        tree.skirtTreeHorizontal();
        System.out.println("------------");
        tree.add(10);//right small
        tree.skirtTreeHorizontal();
        System.out.println("------------");
        tree.add(100);
        tree.skirtTreeHorizontal();
        System.out.println("------------");
        tree.add(110);//left small
        tree.skirtTreeHorizontal();
        System.out.println("------------");
        tree.add(80);//left big
        tree.skirtTreeHorizontal();
        System.out.println("------------");
        tree.del(10);//left small*
        tree.skirtTreeHorizontal();
        System.out.println("------------");
        tree.del(110);
        tree.del(80);//right big
        tree.skirtTreeHorizontal();
        System.out.println("------------");
        tree.skirtTree();
    }
}
