package com.walking.lesson65.Task1;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class CounterService {
    AtomicReference[] counters;
    int total;

    public CounterService(int num){
        this.total = num;
        this.counters = Stream
                .generate(AtomicReference::new)
                .limit(num)
                .toArray(AtomicReference[]::new);
    }

    public void attach(int num, Counter counter){
        if (num >= this.total){
            System.out.println("out of bounds");
        }
        else if (this.counters[num].get() != null) {
            System.out.println("Can't attach the counter");
        } else {
            this.counters[num].set(counter);
            System.out.println("Counter ID%d attached".formatted(num));
        }
    }

    public void detach(int num){
        if (num >= this.total){
            System.out.println("out of bounds");
        }
        else if (this.counters[num].get() == null) {
            System.out.println("Can't detach non-existent id");
        } else {
            this.counters[num].set(null);
            System.out.println("Counter ID%d detached".formatted(num));
        }
    }


}
