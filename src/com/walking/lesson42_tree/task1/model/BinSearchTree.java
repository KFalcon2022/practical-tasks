package com.walking.lesson42_tree.task1.model;

import java.util.Comparator;
import java.util.NoSuchElementException;

import com.walking.lesson39_queue1.task3.model.TwoLinkedList;

public class BinSearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private Comparator<T> comparator;

    public BinSearchTree(){
        this.root=null;
        this.comparator=new Comparator<T>() {

            @Override
            public int compare(T arg0, T arg1) {
                return arg0.compareTo(arg1);
            }
        };
    }

    public BinSearchTree(Comparator<T> comparator){
        this.root=null;
        this.comparator=comparator;
    }



    public void add(T value){
        this.root=add(value, root);
    }

    private Node<T> add(T value, Node<T> node){
        if (node==null){
            node=new Node<>(value);
            System.out.println("Added node with value: "+node.value.toString());
        } else{
            if (comparator.compare(value, node.value)<=0){
                node.left=add(value, node.left);
                updateHeight(node);
                node=balanceNode(node);
            } else {
                node.right=add(value, node.right);
                updateHeight(node);
                node=balanceNode(node);
            }
        }
        return node;
    }

    public boolean contains(T value){
        Node<T> node=this.contains(value, root);
        if (node!=null){
            return true;
        } else{
            return false;
        }
    }

    private Node<T> contains(T value, Node<T> node){
        if (node==null){
            return null;
        } else{
            int compare=comparator.compare(value, node.value);
            if (compare==0){
                return node;
            } else if(compare<0){
                return contains(value, node.left);
            } else {
                return contains(value, node.right);
            }
        }
    }

    public boolean del(T value){
        try {
            root=del(value, root);
        } catch (NoSuchElementException e) {
            if (e.getMessage().equals("Not found"))
            return false;
        }
        return true;
    }

    private Node<T> del(T value, Node<T> targetNode){
        if(targetNode==null){
            throw new NoSuchElementException("Not found");
        }
        if (comparator.compare(value, targetNode.value)==0){
            if (targetNode.left==null|targetNode.right==null){
                targetNode=(targetNode.left==null) ? targetNode.right : targetNode.left;
                //targetNode=balanceNode(targetNode); necessary?
                System.out.println("Deleted node with value: "+value.toString());
            } else{// 2 children
                Node<T> maxInLeft=getMax(targetNode.left);
                targetNode.value=maxInLeft.value;
                targetNode.left=del(maxInLeft.value, targetNode.left);
                System.out.println("Deleted node with value: "+value.toString());
                updateHeight(targetNode);
                targetNode=balanceNode(targetNode);
            }
        } else{ if (comparator.compare(value, targetNode.value)<0){
            targetNode.left=del(value, targetNode.left);
            updateHeight(targetNode);
            targetNode=balanceNode(targetNode);
        } else {
            targetNode.right=del(value, targetNode.right);
            updateHeight(targetNode);
            targetNode=balanceNode(targetNode);
        }
        }
        return targetNode;
    }

    private Node<T> getMax(Node<T> node){
        if(node==null){
            return null;
        }else if (node.right==null){
            return node;
        } else{
            return getMax(node.right);
        }
    }

    private void updateHeight(Node<T> node){
        if(node.left==null&node.right==null){
            node.height=1;
        } else if (node.left==null){
            node.height=node.right.height+1;
        } else if (node.right==null){
            node.height=node.left.height+1;
        } else{
            node.height=(node.left.height>=node.right.height)?node.left.height+1:node.right.height+1;
        }
    }

    private Node<T> balanceNode(Node<T> node){
        int balance=getHeight(node.right)-getHeight(node.left);
        if(balance==-2){//right turn
            int leftBalance=getHeight(node.left.right)-getHeight(node.left.left);
            // if(leftBalance==-1){//small
            //     node=rightTurn(node);
            // }
            // if(leftBalance==1){//big
            //     node.left=leftTurn(node.left);
            //     node=rightTurn(node);
            // }
            if (leftBalance>0){
                node.left=leftTurn(node.left);
            }
            node=rightTurn(node);
        }
        if(balance==2){//left turn
            int rightBalance=getHeight(node.right.right)-getHeight(node.right.left);
            // if(rightBalance==1){//small
            //     node=leftTurn(node); 
            // }
            // if(rightBalance==-1){//big
            //     node.right=rightTurn(node.right);
            //     node=leftTurn(node);
            // }
            if (rightBalance<0){
                node.right=rightTurn(node.right);
            } 
            node=leftTurn(node);
        }
        return node;
    }

    private Node<T> leftTurn(Node<T> node){
        Node<T> temp=node.right;
        node.right=temp.left;
        temp.left=node;
        node=temp;
        updateHeight(node.left);
        updateHeight(node);
        System.out.println("turn left tree with root value: "+node.value.toString());
        return node;
    }

    private Node<T> rightTurn(Node<T> node){
        Node<T> temp=node.left;
        node.left=temp.right;
        temp.right=node;
        node=temp;
        updateHeight(node.right);
        updateHeight(node);
        System.out.println("turn right tree with root value: "+node.value.toString());
        return node;
    }

    private int getHeight(Node<T> node){
        return (node==null)?0:node.height;
    }

    public void skirtTree(){
        skirtTree(root);
    }

    private void skirtTree(Node<T> node){
        if (node==null) return;
        skirtTree(node.left);
        System.out.println(node.value.toString()+ " ");
        skirtTree(node.right);
    }

    public void skirtTreeHorizontal(){
        TwoLinkedList<Node<T>> queue=new TwoLinkedList<>();
        skirtTreeHorizontal(root, queue);
    }

    private void skirtTreeHorizontal(Node<T> node, TwoLinkedList<Node<T>> queue) {
        if(node==null) return;
        if(node.left!=null)
            queue.addLast(node.left);
        if(node.right!=null)
            queue.addLast(node.right);
        System.out.println(node.value.toString()+ " ");
        skirtTreeHorizontal(queue.delFirst(), queue);

    }
    
}

class Node<Type> {
    public Type value;
    public Node<Type> left;
    public Node<Type> right;
    public int height;

    public Node(Type value){
        this.value=value;
        this.height=1;
        this.left=null;
        this.right=null;
    }
}
