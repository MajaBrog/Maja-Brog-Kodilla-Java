package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaTestSuite {
    @Test
    public void TestPepperoni() {
        //Given
        Pizza pizza = new Margherita();
        pizza = new Pepperoni(pizza);
        //When
        BigDecimal totalCost = pizza.getCost();
        String pizzaDescription = pizza.getDescription();
        //Then
        Assert.assertEquals(new BigDecimal(20), totalCost);
        Assert.assertEquals("tomato sauce, mozzarella, pepperoni", pizzaDescription);
    }

    @Test
    public void TestHawaiiWithExtraMozarellaAndGarlicSauce() {
        //Given
        Pizza pizza = new Margherita();
        pizza = new Hawaii(pizza);
        pizza= new ExtraMozzarella(pizza);
        pizza=new GarlicSauce(pizza);
        //When
        BigDecimal totalCost = pizza.getCost();
        String pizzaDescription = pizza.getDescription();
        //Then
        Assert.assertEquals(new BigDecimal(32.5), totalCost);
        Assert.assertEquals("tomato sauce, mozzarella, ham, pineapple, extra mozzarella, garlic sauce", pizzaDescription);
    }
}
