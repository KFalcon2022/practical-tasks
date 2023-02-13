package com.walking.lesson41.Task1;

public class Main {
    public static void main(String[] args){
        TaskService taskQueue = new TaskService();
        taskQueue.add(new Task("First"));
        taskQueue.add(new Task("Second"));
        taskQueue.run();
        taskQueue.add(new Task("Third"));
        taskQueue.add(new Task("Fourth"));
        taskQueue.run();
        taskQueue.add(new Task("Fifths"));
        while (!taskQueue.isEmpty()){
            taskQueue.run();
        }
    }
}