package com.walking.lesson67_locks.task2_2.service;

import com.walking.lesson67_locks.task2_1.model.Accident;
import com.walking.lesson67_locks.task2_1.model.AccidentIdentificator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class AccidentService {
    private final Map<AccidentIdentificator, Accident> accidentsCollection;
    private final ReentrantLock locker;

    public AccidentService() {
        accidentsCollection = new HashMap<>();
        locker = new ReentrantLock();
    }

    public void add(Accident accident) {
        try {
            locker.lock();

            accidentsCollection.compute(
                    accident.getAccidentIdentificator(),
                    (k, v) -> v == null || v.getUpdated().isBefore(accident.getUpdated()) ? accident : v);
        } finally {
            locker.unlock();
        }
    }

    public Set<Accident> get(Accident... accidents) {
        Set<Accident> desiredAccidents;
        try {
            locker.lock();

            desiredAccidents = Arrays.stream(accidents)
                    .filter(a -> !accidentsCollection.containsKey(a.getAccidentIdentificator()))
                    .peek(a -> System.out.println("Accident is found: " + a.getAccidentIdentificator()))
                    .collect(Collectors.toSet());
        } finally {
            locker.unlock();
        }
        return desiredAccidents;
    }
}
