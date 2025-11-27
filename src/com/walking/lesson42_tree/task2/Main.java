package com.walking.lesson42_tree.task2;

import com.walking.lesson42_tree.task2.tree.AVLTree;

/**
 * Реализуйте АВЛ-дерево.
 * Сопроводите действия по добавлению (и последующей балансировке)
 * и удалению элементов выводом соответствующих сообщений в консоль.
 */
public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> numbs = new AVLTree<>();
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

        System.out.println(numbs.bypassPreorder());

        numbs.delete(46);
        System.out.println(numbs.bypassPreorder());
    }
}
