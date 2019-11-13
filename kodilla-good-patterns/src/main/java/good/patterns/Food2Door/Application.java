package good.patterns.Food2Door;

import good.patterns.Food2Door.Model.Order;

public class Application {
    public static void main(String[] args) {
        OrderRetriever orderRetriever = new OrderRetriever();
        Order order = orderRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(orderRetriever.retrieve().getSupplier());
        orderProcessor.orderRealization(order);
    }
}