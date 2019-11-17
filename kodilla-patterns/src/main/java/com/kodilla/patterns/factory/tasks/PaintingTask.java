package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;

    public PaintingTask(String taskName, String color, String whatToPaint){
        this.taskName=taskName;
        this.color=color;
        this.whatToPaint=whatToPaint;

    }

    @Override
    public String toString() {
        return "PaintingTask{" +
                "taskName='" + taskName + '\'' +
                ", color='" + color + '\'' +
                ", whatToPaint='" + whatToPaint + '\'' +
                '}';
    }
    @Override
    public boolean executeTask() {
        System.out.println("Executing Painting task");
        return true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

}
