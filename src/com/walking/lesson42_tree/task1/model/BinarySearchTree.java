package com.walking.lesson42_tree.task1.model;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinarySearchTree{
	private Node root;

	public void add(int key){
		Node current = root;
		if (isEmpty()){
			root = new Node(key);
		}else {
			while (true) {
				if (key <= current.key && current.left != null) {
					current = current.left;
				} else if (key > current.key && current.right != null) {
					current = current.right;

				} else if (key <= current.key) {
					current.left = new Node(key);
					return;
				} else {
					current.right = new Node(key);
					return;
				}
			}
		}
	}

	public Node deepFirstSearch (int key){
		if (!isEmpty()){
			Node current = root;
			while (true) {
				if (key == current.key) {
					return current;
				}
				if (key < current.key && current.left != null) {
					current = current.left;
				} else if (key > current.key && current.right != null){
					current  = current.right;
				} else {
					return null;
				}
			}
		}
		return null;
	}

	public void deepAllPrint(){
		if (!isEmpty()){
			Stack<Node> stack = new Stack<>();
			stack.push(root);

			while (!stack.isEmpty()){
				Node current = stack.pop();
				System.out.println(current.key);

				if (current.left !=null){
					stack.push(current.left);
				}

				if (current.right !=null){
					stack.push(current.right);
				}
			}
		}
	}

	public void breadthAllPrint(){
		if (!isEmpty()) {
			ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<>();
			queue.offer(root);

			while (!queue.isEmpty()){
				Node current = queue.poll();
				System.out.println(current.key);


				if (current.left !=null){
					queue.offer(current.left);
				}

				if (current.right !=null){
					queue.offer(current.right);
				}
			}
		}
	}

	public boolean isEmpty(){
		return root == null;
	}


	public static class Node{
		private final int key;
		private Node left;
		private Node right;

		public Node(int key) {
			this.key = key;
		}
	}
}
