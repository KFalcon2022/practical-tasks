package com.walking.lesson17_enum.task1.model;

public enum Message {
    HI("Hi"),
    HELLO("Hello"),
    BYE("Bye"),
    GOOD_BYE("Good bye"),
    HOW_ARE_YOU("How are you"),
    HOW_ARE_YOU_DOING("How are your doing");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return this.msg;
    }
}
