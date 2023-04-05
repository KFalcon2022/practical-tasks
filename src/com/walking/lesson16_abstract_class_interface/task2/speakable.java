package Lesson16.Task2;

public interface speakable {
    String hello = "Hi";
    String bye = "Bye";
    String how = "How are you";
    default String answer()
    {
        return "No message";
    }
    static String answer(String message)
    {
        if (message.equalsIgnoreCase(hello))
            return "Hello";
        else if (message.equalsIgnoreCase(bye))
            return "Good bye";
        else if (message.equalsIgnoreCase(how))
            return "How are you doing";
        return "Unknown message";
    }
}
