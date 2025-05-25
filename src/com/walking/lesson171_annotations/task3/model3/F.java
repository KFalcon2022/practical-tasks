package com.walking.lesson171_annotations.task3.model3;


import com.walking.lesson171_annotations.task3.annotation.Component;
import com.walking.lesson171_annotations.task3.model1.A;
import com.walking.lesson171_annotations.task3.model1.B;

@Component
public class F {
    private final A a;
    private final B b;
    private final G g;

    public F(A a, B b, G g) {
        this.a = a;
        this.b = b;
        this.g = g;
    }
}
