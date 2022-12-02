package com.walking.lesson16_abstract_class_interface.task22.talk;

public class Hi implements Phrase {

    private static final String HI = "Hi";

    @Override
    public String getPhrase() {
        return HI;
    }
}
