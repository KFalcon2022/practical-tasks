package com.walking.lesson40_queue2.service;

import com.walking.lesson39_queue1.task4.model.Queue;
import com.walking.lesson40_queue2.model.Task;

public class TaskManager {
    Queue<Task> queue=new Queue<>();

    public void addTask(String name, String description, String term){
        lhSet.offer(new Task(name, description, term));
        System.out.println("Успешно добавлено задание: "+name);
    }
    
    public void completeTask(){
        if (lhSet.size()==0){
            System.out.println("Заданий нет");
            return;
        }
        Task temp=lhSet.poll();
        if (temp.late()){
            System.out.println("С опозданием выполнено задание: "+temp.name);
        } else {
            System.out.println("Вовремя выполнено задание: "+temp.name);
        }
    }

    public String getNextTask(){
        if (lhSet.size()==0)
            return "Заданий нет";
        StringBuilder task=new StringBuilder(lhSet.peek().name+"\n");
        task.append(lhSet.peek().description+"\n");
        task.append("Срок до "+lhSet.peek().term.toString());
        return task.toString();
        
    }
}