package com.walking.lesson17_enum.task1.enums;

public enum Greeting {
    HI("Hi","Hello"),
    BYE("Bye","Good bye"),
    HOW_R_U("How are you","How are you doing"),
    OTHER("","Unknown message");

    private final String userInput;
    private final String returnGreeting;

    Greeting(String userInput, String returnGreeting){
        this.userInput = userInput;
        this.returnGreeting = returnGreeting;
    }

    public String getReturnGreeting() {
        return returnGreeting;
    }

    public static Greeting findGreeting(String userEntry) {


        for (Greeting allCase : Greeting.values()) {
            if (allCase.userInput.equals(userEntry)) {
                return allCase;
            }
        }
        return OTHER;
    }
}

