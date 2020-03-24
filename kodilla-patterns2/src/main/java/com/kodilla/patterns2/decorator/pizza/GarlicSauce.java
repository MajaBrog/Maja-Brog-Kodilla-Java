package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class GarlicSauce extends AbstractPizzaDecorator {
    public GarlicSauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2.5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", garlic sauce";
    }
}
