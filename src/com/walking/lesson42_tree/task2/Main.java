package com.walking.lesson42_tree.task2;

import com.walking.lesson42_tree.task2.structure.AVL_Tree;
import com.walking.lesson42_tree.task2.structure.AVL_tree_2;

/**
 * Реализуйте АВЛ-дерево.
 * Сопроводите действия по добавлению (и последующей балансировке)
 * и удалению элементов выводом соответствующих сообщений в консоль.
 */
public class Main {
    public static void main(String[] args) {
//        AVL_Tree<Integer> tree = new AVL_Tree<>();
        AVL_tree_2<Integer> tree = new AVL_tree_2<>();
        for (int i = 9; i > 0; i--) {
            tree.add(i);
        }

//        tree.add(30);
//        tree.add(57);
//        tree.add(18);
//        tree.add(65);
//        tree.add(40);
//        tree.add(9);
//        tree.add(96);
//        tree.add(24);
//        tree.add(12);
//        tree.add(98);
//        tree.add(62);
//        tree.add(55);
//        tree.add(31);
//        tree.add(20);


        tree.delete(6);
        System.out.println("lvl: " + tree.getTreeHeight());
    }
}
