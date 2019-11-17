package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
    private String taskName;
    private String whatToBuy;
    private double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "ShoppingTask{" +
                "taskName='" + taskName + '\'' +
                ", whatToBuy='" + whatToBuy + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean executeTask() {
        System.out.println("Executing Shopping task");
        return true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

}
