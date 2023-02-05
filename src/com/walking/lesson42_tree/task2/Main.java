package com.walking.lesson42_tree.task2;

import com.walking.lesson42_tree.task2.tree.MyTreeV2;

public class Main {
    public static void main(String[] args) {

        MyTreeV2<Integer> myTreeV2 = new MyTreeV2<>();

        initTree(myTreeV2);

        myTreeV2.printNodes();

        myTreeV2.remove(0);
        myTreeV2.remove(2);
        myTreeV2.remove(6);
        myTreeV2.remove(4);

        initTreeV2(myTreeV2);
//        myTreeV2.add(9);

//        myTreeV2.printNodes();
        myTreeV2.printNodesV2();

        System.out.println();
    }

    public static void initTree(MyTreeV2<? super Integer> treeV2) {
        for (int i = 0; i < 20; i++) {
            treeV2.add(i);
        }
    }
    public static void initTreeV2(MyTreeV2<? super Integer> treeV2) {
        for (int i = 0; i < 20; i++) {
            treeV2.add(8);
        }
    }
}
