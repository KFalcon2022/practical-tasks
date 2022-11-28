package com.walking.lesson20_exceptions.task3.exception;

public class ArrayValidationException extends RuntimeException {
    public ArrayValidationException(int elementNumber) {
//        Сообщение, по сути, константно, нет смысла передавать его каждый раз.
//        Зато есть смысл передать номер элемента
        super("Null element in array. Element's number: " + elementNumber);
    }
}