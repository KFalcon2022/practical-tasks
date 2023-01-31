package com.walking.lesson41.Task1;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskService {
    private final Set<Task> queue;

    public TaskService(){
        queue = new LinkedHashSet<Task>();
    }

    public void add(Task task){
        if (queue.add(task)) {
            System.out.println(task.getName() + " added");
        }
    }

    public void run(){
        Iterator<Task> it = queue.iterator();
        if (it.hasNext()){
            Task task = it.next();
            queue.remove(task);
            System.out.println(task.getName() + " executed");
        } else {
            System.out.println("Nothing to execute");
        }
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
