package com.walking.lesson171_annotations.task3.model2;


import com.walking.lesson171_annotations.task3.annotation.Component;
import com.walking.lesson171_annotations.task3.model1.A;
import com.walking.lesson171_annotations.task3.model1.B;

@Component
public class E {
    private final A a;
    private final B b;
    private final D d;

    public E(A a, B b, D d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }
}
