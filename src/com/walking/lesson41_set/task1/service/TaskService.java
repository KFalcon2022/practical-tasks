package com.walking.lesson41_set.task1.service;

import com.walking.lesson40_queue2.models.Task;

import java.util.TreeSet;

public class TaskService {
    private final TreeSet<Task> tasksSet;

    public TaskService(){
        tasksSet=new TreeSet<>();
    }
    public TaskService(Task ...tasks){
        this();
        add(tasks);
    }
    public void add (Task ...tasks){
        for (Task task:tasks){
            tasksSet.add(task);
            System.out.println("Task "+task.getNAME()+" (time: "+task.getTIME_OF_CREATION()+") added.");
        }
    }
    public void perform (){
        if (tasksSet.isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        Task deletedTask = tasksSet.pollFirst();
        System.out.println("Task "+deletedTask.getNAME()+" (time: "+deletedTask.getTIME_OF_CREATION()+") deleted.");
    }

}
