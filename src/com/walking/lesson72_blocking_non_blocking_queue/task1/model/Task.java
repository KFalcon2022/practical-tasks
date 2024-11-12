package com.walking.lesson72_blocking_non_blocking_queue.task1.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    public String name;
    public String description;
    public LocalDate term;
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Task(String name, String description, String term){
        this.name=name;
        this.description=description;
        this.term=LocalDate.parse(term, dtf);
    }

    public boolean late(){
        return term.isBefore(LocalDate.now());
    }
}
