package com.walking.lesson17_enum.task1.enums;

public enum Answers {
    HI("Hi","Hello"),
    BYE("Bye","Good bye"),
    HOW_ARE_YOU("How are you","How are your doing")
    ;
    private String request;
    private String response;

    Answers(String request, String response){
        this.request = request;
        this.response = response;
    }

    public String getRequest() {
        return request;
    }

    public String getResponse() {
        return response;
    }

    public static String getAnswer(String s){
        String res = "Unknown message";
        for (Answers a:Answers.values()) {
            if (a.getRequest().equals(s)){
                res = a.getResponse();
                break;
            }
        }
        return res;
    }
}
