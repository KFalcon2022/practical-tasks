package com.walking.lesson37_collection_list.task1.service;
import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.ArrayList;

public class CounterService{
	private final ArrayList<Counter> counters;

	public CounterService(Counter... counters) {
		this.counters = new ArrayList<>();
		for (Counter counter: counters){
			addCounter(counter);
		}
	}

	public Counter addCounter(Counter counter) {
		counters.add(counter);

		return counters.get(counters.size() - 1);
	}

	public ArrayList<Counter> getAllCounters() {
		return counters;
	}

	public Counter getCounterByName(String name) {
		for (Counter c : counters) {
			if (c.getName().equals(name)) {
				return c;
			}
		}

		return null;
	}

	public Counter increaseCounter(String name, int value) {
		Counter counter = getCounterByName(name);


		if (counter == null) {
			return null;
		}

		return increaseCounter(counter, value);
	}

	public Counter increaseCounter(Counter counter, int value) {
		counter.setValue(counter.getValue() + value);

		return counter;
	}

	public Counter decreaseCounter(String name, int value) {
		Counter counter = getCounterByName(name);

		if (counter == null) {
			return null;
		}

		return decreaseCounter(counter, value);
	}

	public Counter decreaseCounter(Counter counter, int value) {
		counter.setValue(counter.getValue() - value);

		return counter;
	}

	public Counter incrementCounter(String name) {
		Counter counter = getCounterByName(name);

		if (counter == null) {
			return null;
		}

		return incrementCounter(counter);
	}

	public Counter incrementCounter(Counter counter) {
		increaseCounter(counter, 1);

		return counter;
	}

	public Counter decrementCounter(String name) {
		Counter counter = getCounterByName(name);

		if (counter == null) {
			return null;
		}

		return decrementCounter(counter);
	}

	public Counter decrementCounter(Counter counter) {
		decreaseCounter(counter, 1);

		return counter;
	}

	public Counter reset(String name) {
		Counter counter = getCounterByName(name);

		if (counter == null) {
			return null;
		}

		return reset(counter);
	}

	public Counter reset(Counter counter) {
		counter.setValue(0);

		return counter;
	}

	private ArrayList<Counter> copyList(ArrayList<Counter> oldArray, ArrayList<Counter> newArray) {
		newArray.addAll(oldArray);

		return newArray;
	}
}
