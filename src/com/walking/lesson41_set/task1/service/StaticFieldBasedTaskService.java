package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

//Решение, основанное на неком счетчике. Возможны вариации, в данном случае - счетчик представлен статическим полем
// вложенного класса-обертки. Коллекция, в итоге, представлена элементами врапперов, а не самих заданий
public class StaticFieldBasedTaskService implements TaskService {
    private final NavigableSet<TaskWrapper> tasks = new TreeSet<>();

    @Override
    public Task add(Task task) {
        tasks.add(new TaskWrapper(task));
        System.out.printf("Task '%s' added!\n", task.getName());

        return task;
    }

    @Override
    public void complete() {
        if (tasks.isEmpty()) {
            System.out.println("Tasks' queue is empty!");
        } else {
            TaskWrapper taskWrapper = tasks.first();
            tasks.remove(taskWrapper);

            System.out.printf("Task '%s' completed!\n", taskWrapper.task.getName());
        }
    }

    private static class TaskWrapper implements Comparable<TaskWrapper> {
        private static long counter = 0;

        private final long orderValue;
        private final Task task;

        public TaskWrapper(Task task) {
            this.task = task;
            this.orderValue = counter++;
        }

        @Override
        public int compareTo(TaskWrapper o) {
            return Long.compare(this.orderValue, o.orderValue);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            TaskWrapper that = (TaskWrapper) o;
            return orderValue == that.orderValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderValue);
        }
    }
}
