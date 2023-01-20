package com.walking.lesson40.Task1;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskService {
    private final Queue<Task> queue;

    public TaskService(){
        queue = new ArrayDeque();
    }

    public void add(Task task){
        if (queue.offer(task)) {
            System.out.println(task.getName() + " added");
        }
    }

    public void run(){
        Task task = queue.poll();
        if (task != null) {
            System.out.println(task.getName() + " executed");
        } else {
            System.out.println("Nothing to execute");
        }
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
