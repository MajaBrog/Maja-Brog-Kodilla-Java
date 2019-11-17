package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.Bigmac.BigmacBuilder;
import org.junit.Assert;
import org.junit.Test;


public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigMac = new BigmacBuilder()
                .bun(Bun.WITH_SESAME)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .ingredients(Ingredients.LETTUCE)
                .ingredients(Ingredients.CHEESE)
                .ingredients(Ingredients.ONION)
                .build();
        System.out.println(bigMac);
        //When
        int quantityOfIngredients = bigMac.getIngredients().size();
        //Then
        Assert.assertEquals(3, quantityOfIngredients);
    }
}