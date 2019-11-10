package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<String> tasks;

    public List<String> getTasks() {
        return tasks;
    }

    public TaskList() {
        tasks=new ArrayList<>();
    }

    public void add(String task) {
        tasks.add(task);
    }
    public String get(int taskNumber) {
        return tasks.get(taskNumber);
    }

}
