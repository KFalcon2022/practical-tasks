package com.walking.lesson20_exceptions.task3.exception;

public class ArrayValidationException extends RuntimeException {
    private final int num;
    public ArrayValidationException(String message, int num) {
        super(message);
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + getNum();
    }
}
