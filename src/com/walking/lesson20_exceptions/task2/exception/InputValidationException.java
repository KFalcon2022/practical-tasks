package com.walking.lesson20_exceptions.task2.exception;

//Делаем исключение unchecked, поскольку его возникновение -
//исключительно ошибка поведения по вине пользователя
public class InputValidationException extends RuntimeException {
    public InputValidationException(String message) {
        super(message);
    }
}
