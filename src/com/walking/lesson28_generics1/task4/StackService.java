package com.walking.lesson28_generics1.task4;

import com.walking.lesson28_generics1.task4.exceptions.ElementNotFoundException;
public class  StackService <T>{
	private Node <T> head;
	private int length = 0;
	private Node <T> tail;

	public void addElement (T data){
		if (head == null){
			head = new Node<>(data, null);
			tail = head;
		}else {
			tail.nextNode = new Node<> (data, null);
			tail = tail.nextNode;
		}
		++length;
	}

/*	public void removeElement (Integer data) throws ElementNotFoundException {
		if (head.data.equals(data)) {
			head = head.nextNode;
			--length;
			return;
		}
		for (Node currentElem = head; currentElem != null; currentElem = currentElem.nextNode){
			if(currentElem.nextNode.data.equals(data)){
				currentElem.nextNode = currentElem.nextNode.nextNode;
				--length;
				return;
			}
		}

		throw new ElementNotFoundException("Element not found!");
	}*/

	public void removeElement (T data) throws ElementNotFoundException {
		if (head.data.equals(data)) {
			head = head.nextNode;
			--length;
			return;
		}
		Node <T> previousElem = head;
		for (Node <T> currentElem = head.nextNode; currentElem != null; currentElem = currentElem.nextNode){
			if(currentElem.data.equals(data)){
				previousElem.nextNode = currentElem.nextNode;
				--length;
				return;
			}
			previousElem = currentElem;
		}

		throw new ElementNotFoundException("Element not found!");
	}

	public Integer getLength (){
		return length;
	}

	public  T searchElement (T data) throws ElementNotFoundException{
		for (Node <T> currentElem = head; currentElem != null; currentElem = currentElem.nextNode){
			if (currentElem.data.equals(data)) {
				return currentElem.data;
			}
		}
		throw new ElementNotFoundException("Element not found!");
	}

	@Override
	public String toString() {
		StringBuilder arr = new StringBuilder("[");
		for (Node <T> i = head; i != null; i = i.nextNode) {
			arr.append(i.data);
			if (i != (tail)) {
				arr.append(", ");
			}
		}
		arr.append("]");
		return arr.toString();
	}

	private static class Node <T>{
		Node <T> nextNode;
		T data;

		private Node(T data, Node <T> nextNode) {
			this.nextNode = nextNode;
			this.data = data;
		}
	}
}