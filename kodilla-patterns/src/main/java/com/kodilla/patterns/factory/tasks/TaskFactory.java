package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING";
    public static final String PAINTING_TASK = "PAINTING";
    public static final String DRIVING_TASK = "DRIVING";

    public final Task createTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("Buy", "apples",2.0);
            case PAINTING_TASK:
                return new PaintingTask("Paint","red","apple");
            case DRIVING_TASK:
                return new DrivingTask("Drive"," to Warsaw", "by car");
            default:
                return null;
        }

    }
}
