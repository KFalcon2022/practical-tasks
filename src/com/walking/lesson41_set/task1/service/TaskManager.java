package com.walking.lesson41_set.task1.service;

import java.util.LinkedHashSet;

import com.walking.lesson41_set.task1.model.Task;

public class TaskManager {
    LinkedHashSet<Task> lhSet=new LinkedHashSet<>();

    public void addTask(String name, String description, String term){
        lhSet.add(new Task(name, description, term));
        System.out.println("Успешно добавлено задание: "+name);
    }
    
    public void completeTask(){
        if (lhSet.size()==0){
            System.out.println("Заданий нет");
            return;
        }
        Task temp=null;
        for (Task task : lhSet) {
            temp=task;
            break;
        }
        lhSet.remove(temp);
        if (temp.late()){
            System.out.println("С опозданием выполнено задание: "+temp.name);
        } else {
            System.out.println("Вовремя выполнено задание: "+temp.name);
        }
    }

    public String getNextTask(){
        if (lhSet.size()==0)
            return "Заданий нет";
        Task temp=null;
        for (Task task : lhSet) {
            temp=task;
            break;
        }
        StringBuilder task=new StringBuilder(temp.name+"\n");
        task.append(temp.description+"\n");
        task.append("Срок до "+temp.term.toString());
        return task.toString();
        
    }
}
