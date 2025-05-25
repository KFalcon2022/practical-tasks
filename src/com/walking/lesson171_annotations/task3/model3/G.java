package com.walking.lesson171_annotations.task3.model3;


import com.walking.lesson171_annotations.task3.annotation.Component;
import com.walking.lesson171_annotations.task3.model1.A;


@Component
public class G {
    private final A a;
    private final F f;

    public G(A a, F f) {
        this.a = a;
        this.f = f;
    }
}
