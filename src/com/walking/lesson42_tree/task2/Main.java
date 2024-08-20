package com.walking.lesson42_tree.task2;

import com.walking.lesson42_tree.task1.model.BinSearchTree;

/**
 * Реализуйте АВЛ-дерево.
 * Сопроводите действия по добавлению (и последующей балансировке)
 * и удалению элементов выводом соответствующих сообщений в консоль.
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
