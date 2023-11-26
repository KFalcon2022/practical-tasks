package Lesson28.Task4;

import java.io.BufferedReader;

public class Stack <T> {
    private Node<T> head;
    private static int length = 1;
    public Stack() {
        head = new Node<>();
    }
    public Stack(T object) {
        head = new Node<>(object);
    }
    public Node<T> add(T object) {
        if (head.object == null) {
            head.object = object;
        } else {
            Node<T> node = new Node<>(object);
            node.prevNode = head;
            head = node;
            length++;
        }
        return head;
    }
    public int getLength()
    {
        return length;
    }
    public Node<T> delete() {
        if (head != null) {
            head.object = null;
            head = head.prevNode;
            length--;
            return head;
        }
        else throw new StackElementException(null);
    }
    public String printStack()
    {
        StringBuilder string = new StringBuilder().append("[");
        lineBuilder(head, string);
        return string.append("]").toString();
    }
    private StringBuilder lineBuilder(Node<T> head, StringBuilder string)
    {
        return head != null? lineBuilder(head.prevNode, string.append(head)) : string;
    }
}
