package com.walking.lesson20_exceptions.task3.model;

public class ArrayValidationException extends ArrayIndexOutOfBoundsException {
  public ArrayValidationException(String message) {
    super(message);
  }
}
