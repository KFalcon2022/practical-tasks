package com.walking.lesson42_tree.task1_hard;

import com.walking.lesson42_tree.task1_hard.structure.BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

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
//
//        tree.delete(30);
//        tree.delete(12);
//        tree.delete(62);

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.add(12);
        tree.add(13);
        tree.add(14);
        tree.add(15);

        System.out.println(tree.bypassTree());

//        tree.doBalance();

        System.out.println(tree.bypassTree());


    }
}
