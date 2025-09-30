package com.walking.lesson20_exceptions.task2.exception;

public class InputValidationException extends Exception{
    private final int length;
    private final int shapeType;

    public InputValidationException(int length, int shapeType, String message) {
        super(message);
        this.length = length;
        this.shapeType = shapeType;
    }

    public int getLength() {
        return length;
    }

    public int getShapeType() {
        return shapeType;
    }

}
