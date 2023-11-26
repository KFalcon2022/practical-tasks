package Lesson28.Task3;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.OptionalLong;

public class ArrayGen <T> {
    private final T[] array;
    public ArrayGen(T[] array)
    {
        this.array = array;
    }

    public T find(T value)
    {
        for (T element : array) {
            if (Objects.equals(element, value))
                return element;
        }
        throw new ArrayElementException(value);
    }
}
