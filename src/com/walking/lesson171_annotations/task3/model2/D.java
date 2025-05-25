package com.walking.lesson171_annotations.task3.model2;

import com.walking.lesson171_annotations.task3.annotation.Component;
import com.walking.lesson171_annotations.task3.model1.A;
import com.walking.lesson171_annotations.task3.model1.C;

@Component
public class D {
    private final A a;
    private final C c;

    public D(A a, C c) {
        this.a = a;
        this.c = c;
    }
}
