package com.walking.lesson17_enum.task1.answer;

public enum Answer {
    HI("Hi", "Hello"),
    HOW_ARE_YOU("How are you", "How are you  doing?"),
    BYE("Bye", "Good bye");

    final String answer;
    final String question;

    Answer(String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    public void getAnswer() {
        System.out.println(answer);
    }

    public static void phraseSearch(String question) {
        switch (question) {
            case "Hi":
                Answer.HI.getAnswer();
                break;
            case "How are you":
                Answer.HOW_ARE_YOU.getAnswer();
                break;
            case "Bye":
                Answer.BYE.getAnswer();
                break;
            default:
                System.out.println("Unknown question");
        }
    }
}
