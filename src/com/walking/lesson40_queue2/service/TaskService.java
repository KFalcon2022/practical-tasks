package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TaskService {
    Queue<Task> checkList = new LinkedList<>();

    public boolean add(Task e) {
        checkList.offer(e);
        System.out.printf("Task %s has been added\n", e.getName());

        return true;
    }

    public Task complete() {
        Task task = checkList.poll();


        if (task == null) {
            System.out.println("CheckList is empty");
        } else {
            System.out.printf("Task %s is complete\n", task.getName());
            if (checkList.peek() != null) {
                checkList.peek().setPrev(null);
            }
        }

        return task;
    }




}
