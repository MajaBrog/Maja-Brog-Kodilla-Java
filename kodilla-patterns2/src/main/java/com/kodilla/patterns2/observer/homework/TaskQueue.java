package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TaskQueue  implements Observable {
    private final List<Observer> observers;
    private String User;
    private Queue<String> taskQueue;

    public TaskQueue(String user) {
        observers = new ArrayList<>();
        taskQueue = new ArrayDeque<>();
        User = user;
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addTask(String task){
        taskQueue.offer(task);
        notifyObservers();
    }

    public String getUser() {
        return User;
    }

    public Queue<String> getTaskQueue() {
        return taskQueue;
    }
}
