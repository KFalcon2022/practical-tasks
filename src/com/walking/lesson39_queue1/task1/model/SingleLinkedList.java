package com.walking.lesson39_queue1.task1.model;

import java.rmi.UnexpectedException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SingleLinkedList<T> {
	Node<T> head;
	Node<T> tail;

	private static class Node<T> {
		T data;
		Node<T> next;

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Node<?> node)) return false;
			return Objects.equals(data, node.data);
		}

		@Override
		public int hashCode() {
			return Objects.hash(data) * 31;
		}

		public T getData() {
			return data;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(T node) {
		Node<T> newNode = new Node<>();
		newNode.data = node;
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}

	//Этот метод я взял из своего решения 28 задачи.
	public void removeOne(T data) throws RuntimeException {
		if (!isEmpty()) {
			if (head.data.equals(data)) {
				head = head.next;
				return;
			}
			Node<T> previous = head;
			for (Node<T> current = head.next; current != null; current = current.next) {
				if (current.data.equals(data)) {
					previous.next = current.next;
					return;
				}
				previous = current;
			}

			throw new RuntimeException("Element not found!");
		}
		System.out.println("List is empty!");
	}

	// Этот метод сделал заново, чтобы на его основе сделать метод для удаления нод с чётными хешами.
	public void removeAll(T data) {
		if (!isEmpty()) {
			if (searchForValidation(data)) {
				Node<T> current = head;
				Node<T> previous = current;
				while (current != null) {
					if (head.data.equals(data)) {
						head = head.next;
						previous = current;
					} else if (current.data.equals(data)) {
						previous.next = current.next;
						current = current.next;

					} else {
						previous = current;
						current = current.next;
					}
				}
			} else {
				System.out.println("Element not found!");
			}

		} else {
			System.out.println("List is empty!");
		}
	}

	public void removeEvenHashNodes() {
		if (!isEmpty()) {
			Node<T> current = head;
			Node<T> previous = current;
			while (current != null) {
				if (head.hashCode()%2 == 0) {
					head = head.next;
					previous = current;
				} else if (current.hashCode()%2==0) {
					previous.next = current.next;
					current = current.next;

				} else {
					previous = current;
					current = current.next;
				}
			}
		} else {
			System.out.println("List is empty!");
		}
	}

	public void reverse() {
		if (!isEmpty() && head.next != null) {
			tail = head;
			Node<T> current = head.next;
			head.next = null;
			while (current != null) {
				Node<T> next = current.next;
				current.next = head;
				head = current;
				current = next;
			}
		}
	}

	public T search(T data) throws RuntimeException {
		for (Node<T> currentElem = head; currentElem != null; currentElem = currentElem.next) {
			if (currentElem.data.equals(data)) {
				return currentElem.data;
			}
		}
		throw new RuntimeException("Element not found!");
	}

	public String hashAllNodes(){
		Node<T> current = head;
		StringBuilder str = new StringBuilder();
		while (current != null) {
			str.append(current.hashCode()).append("\n");
			current = current.next;
		}
		return str.toString();
	}
	@Override
	public String toString() {
		Node<T> current = head;
		StringBuilder str = new StringBuilder();
		while (current != null) {
			str.append(current.data).append("\n");
			current = current.next;
		}
		return str.toString();
	}

	private boolean searchForValidation(T data) {
		for (Node<T> currentElem = head; currentElem != null; currentElem = currentElem.next) {
			if (currentElem.data.equals(data)) {
				return true;
			}
		}
		return false;
	}

}
