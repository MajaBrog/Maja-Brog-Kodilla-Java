package com.kodilla.spring.Calculator;

import com.kodilla.spring.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double add = calculator.add(3, 2);
        double sub = calculator.sub(3, 2);
        double mul = calculator.mul(3, 2);
        double div = calculator.div(3, 2);

        Assert.assertEquals(add, 5.0,0);
        Assert.assertEquals(sub, 1.0,0);
        Assert.assertEquals(mul, 6.0,0);
        Assert.assertEquals(div, 1.5,0);
    }
}
