package com.walking.lesson31_io_streams;

public class CastingException extends RuntimeException {
    //    Вместо Class<?> clazz можно использовать строковый параметр, принимающий название типа.
//    Class<> использован в ознакомительных целях
    public CastingException(String value, Class<?> clazz) {
        super("%s cannot be casted to %s".formatted(value, clazz.getSimpleName()));
    }
}