package com.kodilla.testing.shape;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ShapeTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector test1 = new ShapeCollector();
        Shape circle=new Circle(2);
        //When
        test1.addFigure(circle);
        //Then
        List<Shape> shapes=test1.getShapes();
        assertEquals(1, shapes.size());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector test1 = new ShapeCollector();
        Shape circle=new Circle(2);
        test1.addFigure(circle);
        //When
        boolean result=test1.removeFigure(circle);
        //Then
        Assert.assertTrue(result);
        assertEquals(0, test1.getShapes().size());
    }
    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector test1 = new ShapeCollector();
        Shape circle=new Circle(2);
        //When
        boolean result=test1.removeFigure(circle);
        //Then
        Assert.assertFalse(result);
        assertEquals(0, test1.getShapes().size());
    }
    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector test1 = new ShapeCollector();
        Shape circle=new Circle(2);
        test1.addFigure(circle);
        //When
        Shape retrievedFigure;
        retrievedFigure=test1.getFigure(0);
        //Then
        assertEquals(circle, retrievedFigure);
    }
}
