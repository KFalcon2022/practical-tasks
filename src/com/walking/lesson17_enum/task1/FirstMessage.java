package Lesson17.Task1;

public class FirstMessage implements Interactive, Speakable{
    String userMessage;

    public void interpretationUserMessage()
    {
        this.userMessage = Interactive.getMessage();
        switch (this.userMessage)
        {
            case "hi":
                System.out.println(Message.GREETINGS.getAnswer());
                break;
            case "bye":
                System.out.println(Message.FAREWELL.getAnswer());
                break;
            case "how are you":
                System.out.println(Message.QUESTION.getAnswer());
                break;
            default:
                System.out.println("I don't understand, please repeat");
                interpretationUserMessage();
        }
    }
}