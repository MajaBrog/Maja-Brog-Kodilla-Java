package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testTaskFactoryShopping(){
        //Given
        TaskFactory factory=new TaskFactory();

        //When
        Task shoppingTask=factory.createTask(TaskFactory.SHOPPING_TASK);

        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Buy",shoppingTask.getTaskName());

    }

    @Test
    public void testTaskFactoryPainting(){
        //Given
        TaskFactory factory=new TaskFactory();

        //When
        Task paintingTask=factory.createTask(TaskFactory.PAINTING_TASK);

        //Then
        Assert.assertTrue(paintingTask.isTaskExecuted());
        Assert.assertEquals("Paint",paintingTask.getTaskName());
    }

    @Test
    public void testTaskFactoryDriving(){
        //Given
        TaskFactory factory=new TaskFactory();

        //When
        Task drivingTask=factory.createTask(TaskFactory.DRIVING_TASK);

        //Then
        Assert.assertTrue(drivingTask.isTaskExecuted());
        Assert.assertEquals("Drive",drivingTask.getTaskName());
    }
}
