package com.walking.lesson42_tree.task2;

import com.walking.lesson42_tree.task2.structure.AvlTree;

/**
 * Реализуйте АВЛ-дерево.
 * Сопроводите действия по добавлению (и последующей балансировке)
 * и удалению элементов выводом соответствующих сообщений в консоль.
 */
public class Main {
    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();
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
    }
}
