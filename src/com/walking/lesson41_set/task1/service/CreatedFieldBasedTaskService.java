package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.NavigableSet;
import java.util.TreeSet;

// Реализация, наверно, наиболее близкая к боевой. Сравниваем по времени создания, которое хранится в объекте задания. 
// Возможны вариации - установка значения лишь при добавлении в список или еще что-то в этом роде. 
// Самое забавное, что на тестовых данных эта реализация работает некорректно - между добавлением заданий проходит
// менее наносекунды, соответственно, compareTo() возвращает 0 для заданий, добавленных подряд.
// Тем не менее реализация оставлена в качестве демонстрации концепции - нюансы можно доработать при желании
public class CreatedFieldBasedTaskService implements TaskService {
    private final NavigableSet<Task> tasks = new TreeSet<>();

    @Override
    public Task add(Task task) {
        tasks.add(task);
        System.out.printf("Task '%s' added!\n", task.getName());

        return task;
    }

    @Override
    public void complete() {
        if (tasks.isEmpty()) {
            System.out.println("Tasks' queue is empty!");
        } else {
            Task task = tasks.first();
            tasks.remove(task);

            System.out.printf("Task '%s' completed!\n", task.getName());
        }
    }
}
