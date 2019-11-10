package good.patterns.Order;

import good.patterns.Order.Model.Order;

public class Application {
    public static void main(String[] args) {
        OrderRetriever orderRetriever = new OrderRetriever();
        Order order = orderRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new ProductEmailInformationService(), new ProductOrderService(), new ProductOrderRepository());
        orderProcessor.process(order);
    }
}
