package Lesson28.Task4;

public class Node <T> {
    protected T object;
    protected Node<T> prevNode = null;
    private int nodeNumber;
    public Node () {
        this.object = null;
    }
    public Node (T object) {
        this.object = object;
    }
    protected void setNumber(int number){
        this.nodeNumber = number;
    }
    protected int getNumber(){
        return nodeNumber;
    }
    public String toString()
    {
        return prevNode != null?
            "{Node: <%s> Previous Node: <%s>},".formatted(object, prevNode.object) :
            "{Node: <%s>, Previous Node: <->}".formatted(object);
    }
}
