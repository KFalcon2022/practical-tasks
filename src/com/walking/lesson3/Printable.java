package com.walking.lesson3;

public interface Printable {
    default String print(){
        return "Unknown message, fuck you, please!"; // в меру грубый, вежливый интерфейс
    }
}
