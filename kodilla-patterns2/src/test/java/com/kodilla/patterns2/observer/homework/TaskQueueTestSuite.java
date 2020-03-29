package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskQueueTestSuite {
    @Test
    public void testUpdate() {
        //Given
        TaskQueue students1TaskQueue=new TaskQueue("student1");
        TaskQueue students2TaskQueue=new TaskQueue("student2");
        TaskQueue students3TaskQueue=new TaskQueue("student3");

        Mentor mentor1 = new Mentor("mentor1");
        Mentor mentor2 = new Mentor("mentor2");

        students1TaskQueue.registerObserver(mentor1);
        students2TaskQueue.registerObserver(mentor1);
        students3TaskQueue.registerObserver(mentor2);

        //When
        students1TaskQueue.addTask("task 1.4");
        students1TaskQueue.addTask("task 7.2");
        students2TaskQueue.addTask("task 5.8");
        students2TaskQueue.addTask("task 20.1");
        students3TaskQueue.addTask("task 1.5");
        students3TaskQueue.addTask("task 3.2");
        //Then
        assertEquals(4, mentor1.getUpdateCount());
        assertEquals(2, mentor2.getUpdateCount());

    }
}