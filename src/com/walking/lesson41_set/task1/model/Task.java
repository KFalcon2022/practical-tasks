package com.walking.lesson41_set.task1.model;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private final String name;
    private final String question;
    private final int answer;
    private final int size;

    private static int count = 1;

    public Task(String name, String question, int answer) {
        this.name = name;
        this.question = question;
        this.answer = answer;
        this.size = count++;
    }

    public Task(Task task) {
        this(task.getName(), task.getQuestion(), task.getAnswer());
    }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return answer == task.answer && Objects.equals(name, task.name) && Objects.equals(question, task.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, question, answer);
    }

    @Override
    public int compareTo(Task t) {
        return size - t.getSize();
    }
}
