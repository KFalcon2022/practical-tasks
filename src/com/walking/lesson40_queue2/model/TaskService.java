package com.walking.lesson40_queue2.model;
import java.util.*;

public class TaskService {
	ArrayDeque<Task> taskList = new ArrayDeque<>();
	private int val;

	public TaskService(int val) {
		this.val = val;
	}


	public void addFirst(String name, int value, char oper) {
		taskList.addFirst(new Task(name, value, oper));
		System.out.println("Задание " + name + " добавлено в начало очереди!");
	}

	public void add(String name, int value, char oper) {
		taskList.add(new Task(name, value, oper));
		System.out.println("Задание " + name + " добавлено в конец очереди!");
	}

	public void executeTasks(){
		Task elem = taskList.pollFirst();
		assert elem != null;
		if (elem.getOPER() == '+'){
			val = val + elem.getVALUE();
		}else if (elem.getOPER() == '-'){
			val = val - elem.getVALUE();
		}

		System.out.println("Задание " + elem.getNAME() + " выполнено!");
	}

	public int getResult(){
		return val;
	}


}
