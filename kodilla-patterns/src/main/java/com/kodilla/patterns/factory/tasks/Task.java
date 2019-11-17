package com.kodilla.patterns.factory.tasks;

public interface Task {
    boolean executeTask();

    String getTaskName();

    default boolean isTaskExecuted() {
        boolean isTaskExecuted = executeTask();
        return isTaskExecuted;
    }
}
