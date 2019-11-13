package good.patterns.Food2Door;

import good.patterns.Food2Door.Model.Order;

public class OrderProcessor {
    final Supplier supplier;

    public OrderProcessor(Supplier supplier) {
        this.supplier = supplier;
    }

    void orderRealization(final Order order) {
        OrderService orderService = new OrderService();
        boolean orderPlaced = orderService.order(order);
        if (orderPlaced) {
            supplier.process(order);
            InformationService informationService=new InformationService();
            informationService.inform();
        } else {
            System.out.println("Order hasn't been placed");
        }
    }
}

