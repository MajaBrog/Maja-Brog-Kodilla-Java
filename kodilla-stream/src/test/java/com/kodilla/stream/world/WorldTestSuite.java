package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country poland = new Country("Poland", new BigDecimal("38413000"));
        Country france = new Country("France", new BigDecimal("66992000"));
        Country italy = new Country("Italy", new BigDecimal("60375749"));
        Country japan = new Country("Japan", new BigDecimal("126200000"));
        Country china = new Country("China", new BigDecimal("1399210000"));
        Country egypt = new Country("Egypt", new BigDecimal("99319400"));
        Country kenya = new Country("Kenya", new BigDecimal("52214791"));

        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");

        europe.addCountry(poland);
        europe.addCountry(france);
        europe.addCountry(italy);
        asia.addCountry(japan);
        asia.addCountry(china);
        africa.addCountry(egypt);
        africa.addCountry(kenya);

        World world = new World();

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        //When
        BigDecimal totalPeopleQuantity = BigDecimal.ZERO;
        totalPeopleQuantity = world.getPeopleQuantity();
        //Then
        BigDecimal expectedPeopleQuantity = BigDecimal.ZERO;
        expectedPeopleQuantity = expectedPeopleQuantity.add(poland.getPeopleQuantity());
        expectedPeopleQuantity = expectedPeopleQuantity.add(france.getPeopleQuantity());
        expectedPeopleQuantity = expectedPeopleQuantity.add(italy.getPeopleQuantity());
        expectedPeopleQuantity = expectedPeopleQuantity.add(japan.getPeopleQuantity());
        expectedPeopleQuantity = expectedPeopleQuantity.add(china.getPeopleQuantity());
        expectedPeopleQuantity = expectedPeopleQuantity.add(egypt.getPeopleQuantity());
        expectedPeopleQuantity = expectedPeopleQuantity.add(kenya.getPeopleQuantity());
        Assert.assertEquals(expectedPeopleQuantity, totalPeopleQuantity);
    }
}
