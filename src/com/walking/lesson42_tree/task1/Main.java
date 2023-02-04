package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.tree.MyTree;
import com.walking.lesson42_tree.task1.tree.MyTreeV2;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>();

        MyTree<Integer> myIntegerTree = new MyTree<>(Collections.reverseOrder());

        MyTreeV2<Integer> myTreeV2 = new MyTreeV2<>();


        initNotListTree(myIntegerTree);
        initNotListTree(myTree);
        initNotListTree(myTreeV2);

        myTree.remove(20);
        myTree.remove(45);
        myTree.remove(40);
        myTree.remove(60);
        myTree.remove(50);
        myTree.remove(30);

        myTreeV2.remove(20);
        myTreeV2.remove(45);
        myTreeV2.remove(40);
        myTreeV2.remove(60);
        myTreeV2.remove(50);
        myTreeV2.remove(30);

        myTree.printNodes();
        myTree.printNodesV2();

        myTreeV2.printNodes();
        myTreeV2.printNodesV2();
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

    public static void initNotListTree(MyTreeV2<? super Integer> tree) {
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
