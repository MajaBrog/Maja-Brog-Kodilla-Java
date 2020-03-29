package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class OrderProcessingWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessingWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))"+ "&&args(theOrder, theUserId)&&target(object)")
    public void logEvent(OrderDto theOrder, Long theUserId, Object object) throws NoSuchMethodException{
        LOGGER.info("Class: " + object.getClass().getName()  + " "+theOrder.toString() + ", User Id: " + theUserId);
    }
}
