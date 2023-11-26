package Lesson17.Task1;

public interface Speakable {
    enum Message {GREETINGS("Hello."), FAREWELL("Good bye."), QUESTION("How are you doing.");
        private String answer = "";
        Message(String input)
        {
            this.answer = input;
        }
        public String getAnswer() {
            return answer;
        }
    }
}
