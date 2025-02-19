package com.walking.lesson17_enum.task1;

public enum Greeting {
    HELLO("Hi", "Hello"), BYE("Bye", "Good bye"),
    DOING("How are you", "How are you doing"), UNKNOWN("", "Unknown message");
    private String message;
    private String answer;

    Greeting(String message, String answer) {//это конструктор элементов перечисления (т.е. каждого из приведенных значений енама)
        this.message = message;
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }

    public static String getGreeting(String userMessage) {
        if (userMessage == null){
            return UNKNOWN.answer;
        }
        for (Greeting greeting : Greeting.values()) {
            if (userMessage.equals(greeting.message)) {
                return greeting.getAnswer();
            }
        }
        return UNKNOWN.answer;
    }
}
