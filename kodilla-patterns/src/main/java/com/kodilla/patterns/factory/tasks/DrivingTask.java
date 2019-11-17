package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private String taskName;
    private String where;
    private String using;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String toString() {
        return "DrivingTask{" +
                "taskName='" + taskName + '\'' +
                ", where='" + where + '\'' +
                ", using='" + using + '\'' +
                '}';
    }

    @Override
    public boolean executeTask() {
        System.out.println("Executing Driving task");
        return true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

}
