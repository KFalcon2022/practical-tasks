package Lesson29.Task1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class WildcardGenericExample <T> {
    private T object;
    public WildcardGenericExample() {}
    public WildcardGenericExample(T object) {
        this.object = object;
    }
    public T getObject() {
        return object;
    }
}
