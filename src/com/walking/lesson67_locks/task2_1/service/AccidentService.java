package com.walking.lesson67_locks.task2_1.service;

import com.walking.lesson67_locks.task2_1.model.Accident;
import com.walking.lesson67_locks.task2_1.model.AccidentIdentificator;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class AccidentService {
    private final Map<AccidentIdentificator, Accident> accidentsCollection;
    private final ReentrantReadWriteLock rwLocker;

    public AccidentService() {
        accidentsCollection = new HashMap<>();
        rwLocker = new ReentrantReadWriteLock();
    }

    public void add(Accident accident) {
        try {
            rwLocker.writeLock().lock();

            accidentsCollection.compute(
                    accident.getAccidentIdentificator(),
                    (k, v) -> v == null || v.getUpdated().isBefore(accident.getUpdated()) ? accident : v);
        } finally {
            rwLocker.writeLock().unlock();
        }
    }

    public Set<Accident> get(Accident... accidents) {
        Set<Accident> desiredAccidents;
        try {
            rwLocker.readLock().lock();

            desiredAccidents = Arrays.stream(accidents)
                    .filter(a -> !accidentsCollection.containsKey(a.getAccidentIdentificator()))
                    .peek(a -> System.out.println("Accident is found: " + a.getAccidentIdentificator()))
                    .collect(Collectors.toSet());
        } finally {
            rwLocker.readLock().unlock();
        }
        return desiredAccidents;
    }
}
