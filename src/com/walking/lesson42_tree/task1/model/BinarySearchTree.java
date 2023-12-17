package com.walking.lesson42_tree.task1.model;

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree<T>{

    private Node<T> root;
    private int size;
    private Comparator<T> comparator;
    private int height;
    private int tempHeight;

    public BinarySearchTree(){comparator=null;};
    public BinarySearchTree(Comparator<T> comparator){
        this.comparator=comparator;
    }
    public int getSize(){
        return size;
    }

    public int getHeight() {return height;}

    public void add(T value){
        if (root==null){
            root=new Node<>(value);
            size++;
            height++;
            return;
        }

        tempHeight=1;
        int resultOfCompare = compare(value,root.value);
        if (resultOfCompare>0){
            root.right= add(value,root.right);
        } else {
            root.left = add(value, root.left);
        }
    }
    private Node<T> add(T value, Node<T> root){
        tempHeight++;
        if (height<tempHeight){
            height=tempHeight;
        }

        if (root == null){
            root=new Node<>(value);
            size++;
            return root;
        }
        int resultOfCompare = compare(value,root.value);
        if (resultOfCompare>0){
            root.right=add(value,root.right);
            return root;
        }
        else{
            root.left=add(value,root.left);
            return root;
        }
    }
    private int compare (Object o1, Object o2){
        if (comparator==null){
            return ((Comparable<T>) o1).compareTo((T) o2);
        }
        else{
            return comparator.compare((T) o1,(T) o2);
        }
    }

    public void bypassStraight (){
        bypassStraight(root);
    }
    private void bypassStraight (Node<T> root){
        while (root!=null){
            System.out.println(root.value);
            bypassStraight(root.left);
            bypassStraight(root.right);
            return;
        }
    }
    public void bypassCentre(){
        bypassCentre(root);
    }
    private void bypassCentre(Node<T> root){
        while (root!=null){
            bypassCentre(root.left);
            System.out.println(root.value);
            bypassCentre(root.right);
            return;
        }
    }
    public void bypassReverse(){
        bypassReverse(root);
    }
    private void bypassReverse(Node<T> root){
        while (root!=null){
            bypassReverse(root.left);
            bypassReverse(root.right);
            System.out.println(root.value);
            return;
        }
    }
    public void bypassHorizontal(){
        ArrayList<Node<T>> currentNodes = new ArrayList<>();
        currentNodes.add(root);
        while (currentNodes.size()>0) {
            currentNodes = bypassHorizontal(currentNodes);
        }
        return;
    }
    private ArrayList<Node<T>> bypassHorizontal(ArrayList<Node<T>> currentNodes){
        ArrayList<Node<T>> nextNodes = new ArrayList<>();
        for (Node<T> node : currentNodes) {
            System.out.print(node.value+" ");
            if (node.left!=null) {
                nextNodes.add(node.left);
            }
            if (node.right!=null) {
                nextNodes.add(node.right);
            }
        }
        System.out.println();
        return nextNodes;
    }
    
    private class Node<T>{
        private T value;
        private Node<T> left;
        private Node<T> right;
        public Node(T value){
            this.value=value;
        }
        public Node(T value,Node<T> left, Node<T> right){
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
}
