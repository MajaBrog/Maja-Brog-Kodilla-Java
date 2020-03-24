package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class Pepperoni extends AbstractPizzaDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(5));
    }
    @Override
    public String getDescription(){
        return super.getDescription()+", pepperoni";
    }
}
