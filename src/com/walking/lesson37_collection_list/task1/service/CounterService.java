package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.*;

public class CounterService {
    /*// замена ArrayList на Vector не повлияла на кодовую базу, т.к. они оба реализуют интерфейс List,
    // что делает их взаимозаменяемыми
    private final Vector<Counter> counters;

    public CounterService(Counter... counters) {
        this.counters = new Vector<>(Arrays.asList(counters));
    } */

    private final ArrayList<Counter> counters;

    public CounterService(List<Counter> counters) {
        this.counters = new ArrayList<>(counters);
    }

    public List<Counter> getAllCounters() {
        return List.copyOf(counters);
    }

    public Counter getFirst() {
        return counters.get(0);
    }

    public void addFirst(Counter counter) {
        counters.add(0, counter);
    }

    public Counter addCounter(Counter counter) {
        counters.add(counter);
        return counters.get(counters.size() - 1);
    }

    public boolean addCountersIfAbsent(Counter... counters) {
        List<Counter> candidates = new ArrayList<>(Arrays.asList(counters));
        candidates.removeAll(this.counters);
        return this.counters.addAll(candidates);
    }

    public boolean removeIfNotMatch(Collection<? extends Counter> sample) {
        return counters.retainAll(sample);
    }

    public boolean removeDuplicates() {
        List<Counter> uniques = getUniques();

        if (uniques.size() == counters.size()) {
            return false;
        }

        counters.clear();
        counters.addAll(uniques);
        return true;
    }

    public boolean removeIdleCounters() {
        List<Counter> idles = getIdles();

        if (idles.size() == 0) {
            return false;
        }

        counters.removeAll(idles);
        return true;
    }

    public void sortByName() {
        counters.sort(Comparator.naturalOrder());
    }

    public void sortBy(Comparator<Counter> comparator) {
        counters.sort(comparator);
    }

    public Counter getCounterByName(String name) {
        for (Counter counter : counters) {
            if (counter.getName().equals(name)) {
                return counter;
            }
        }

        return null;
    }

    public Counter increaseCounter(String name, int value) {
        Counter counter = getCounterByName(name);
        return counter == null ? null : increaseCounter(counter, value);
    }

    public Counter increaseCounter(Counter counter, int value) {
        counter.setValue(counter.getValue() + value);
        return counter;
    }

    public Counter decreaseCounter(String name, int value) {
        Counter counter = getCounterByName(name);
        return counter == null ? null : decreaseCounter(counter, value);
    }

    public Counter decreaseCounter(Counter counter, int value) {
        counter.setValue(counter.getValue() - value);
        return counter;
    }

    public Counter incrementCounter(String name) {
        Counter counter = getCounterByName(name);
        return counter == null ? null : incrementCounter(counter);
    }

    public Counter incrementCounter(Counter counter) {
        increaseCounter(counter, 1);
        return counter;
    }

    public Counter decrementCounter(String name) {
        Counter counter = getCounterByName(name);
        return counter == null ? null : decrementCounter(counter);
    }

    public Counter decrementCounter(Counter counter) {
        decreaseCounter(counter, 1);
        return counter;
    }

    public Counter reset(String name) {
        Counter counter = getCounterByName(name);
        return counter == null ? null : reset(counter);
    }

    public Counter reset(Counter counter) {
        counter.setValue(0);
        return counter;
    }

    private List<Counter> getUniques() {
        List<Counter> uniques = new ArrayList<>();

        for (Counter counter : counters) {
            if (!uniques.contains(counter)) {
                uniques.add(counter);
            }
        }

        return uniques;
    }

    private List<Counter> getIdles() {
        List<Counter> idles = new ArrayList<>();

        for (Counter counter : counters) {
            if (isIdle(counter)) {
                idles.add(counter);
            }
        }

        return idles;
    }

    private boolean isIdle(Counter counter) {
        return counter.getValue() == 0;
    }
}