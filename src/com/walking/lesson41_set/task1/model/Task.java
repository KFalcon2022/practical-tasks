package com.walking.lesson41_set.task1.model;

import java.time.LocalDateTime;
import java.util.Objects;

//Класс доработан для реализации NavigableSetBasedTaskService. Добавлено поле created и имплементирован Comparable
// В остальных реализациях можно использовать оригинальную версию сущности
public class Task implements Comparable<Task> {
    private final String name;
    private final LocalDateTime created;

    public Task(String name) {
        this.name = name;
        this.created = LocalDateTime.now();
    }

    @Override
    public int compareTo(Task o) {
        return created.compareTo(o.created);
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(created, task.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, created);
    }
}
