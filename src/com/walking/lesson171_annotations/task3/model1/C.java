package com.walking.lesson171_annotations.task3.model1;

import com.walking.lesson171_annotations.task3.annotation.Component;

@Component
public class C {
    private final B b;

    public C(B b) {
        this.b = b;
    }
}
