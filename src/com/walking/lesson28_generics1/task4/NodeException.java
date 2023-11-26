package Lesson28.Task4;

public class NodeException extends NullPointerException {
    public NodeException(String message)
    {
        super("Node ERROR: " + message);
    }
}
