package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.LinkedHashSet;
import java.util.Set;

public class TaskService {
	Set <Task> taskSet = new LinkedHashSet<>();

	public void add(String name) {
		Task task = new Task(name);
		taskSet.add(task);
		System.out.printf("Задание %s добавлено!\n", task.getNAME());
	}

	public void execute (){
		for (Task task: taskSet) {
			System.out.printf("Задание %s выполнено!\n", task.getNAME());
		}
		taskSet.clear();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Task task: taskSet) {
			stringBuilder.append(task.getNAME()).append("\n");
		}
		return stringBuilder.toString();
	}
}
