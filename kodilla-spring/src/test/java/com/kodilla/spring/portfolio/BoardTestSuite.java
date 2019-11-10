package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        Board board=context.getBean(Board.class);
        TaskList toDoList = (TaskList)context.getBean("toDoList");
        TaskList inProgressList = (TaskList)context.getBean("inProgressList");
        TaskList doneList = (TaskList)context.getBean("doneList");
        toDoList.add("Clean room");
        inProgressList.add("wash dishes");
        doneList.add("Do loundry");
        //Then
        System.out.println("first task from toDoList: " + toDoList.get(0)+ "\nfirst task from inProgressList: "+inProgressList.get(0)+ "\nfirst task from doneList: "+doneList.get(0));
    }
}
