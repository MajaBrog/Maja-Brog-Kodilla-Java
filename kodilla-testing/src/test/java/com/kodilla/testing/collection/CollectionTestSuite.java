package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");

    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator test1=new OddNumbersExterminator();
        ArrayList<Integer> numbers=new ArrayList<Integer>();
        //When
        ArrayList<Integer> evenNumbers=test1.exterminate(numbers);
        //Then
        assertEquals(0, evenNumbers.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator test1=new OddNumbersExterminator();
        ArrayList<Integer> numbers=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
        List<Integer> expectedList= new ArrayList<>(Arrays.asList(2,4,6));
        //When
        ArrayList<Integer> evenNumbers=test1.exterminate(numbers);
        //Then
//        for(Integer number:evenNumbers){
//            Assert.assertEquals(0, number%2);
//        }
        assertEquals(expectedList,evenNumbers);
    }
}
