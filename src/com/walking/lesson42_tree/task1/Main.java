package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.tree.MyTree;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>();

        MyTree<Integer> myIntegerTree = new MyTree<>(Collections.reverseOrder());

        initNotListTree(myIntegerTree);
        initNotListTree(myTree);

        myTree.remove(20);
        myTree.remove(45);
        myTree.remove(40);
        myTree.remove(60);
        myTree.remove(50);
        myTree.remove(30);

        myTree.printNodes();
//        myIntegerTree.printNodes();

        myTree.printNodesV2();
//        myIntegerTree.printNodesV2();
    }

    public static void initNotListTree(MyTree<? super Integer> tree) {
        tree.add(20);
        tree.add(10);
        tree.add(40);
        tree.add(5);
        tree.add(15);
        tree.add(30);
        tree.add(50);
        tree.add(25);
        tree.add(35);
        tree.add(45);
        tree.add(60);
        tree.add(23);
    }
}