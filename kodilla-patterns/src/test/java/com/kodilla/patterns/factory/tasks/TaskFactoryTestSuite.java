package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskFactoryTestSuite {

    private TaskFactory factory;

    @Before
    public void setUp() {
        factory = new TaskFactory();
    }

    @Test
    public void testTaskFactoryShopping() {
        //When
        Task shoppingTask = factory.createTask(TaskFactory.SHOPPING_TASK);

        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Buy", shoppingTask.getTaskName());

    }

    @Test
    public void testTaskFactoryPainting() {
        //When
        Task paintingTask = factory.createTask(TaskFactory.PAINTING_TASK);

        //Then
        Assert.assertTrue(paintingTask.isTaskExecuted());
        Assert.assertEquals("Paint", paintingTask.getTaskName());
    }

    @Test
    public void testTaskFactoryDriving() {
        //When
        Task drivingTask = factory.createTask(TaskFactory.DRIVING_TASK);

        //Then
        Assert.assertTrue(drivingTask.isTaskExecuted());
        Assert.assertEquals("Drive", drivingTask.getTaskName());
    }
}
