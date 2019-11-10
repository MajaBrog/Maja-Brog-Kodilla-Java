package good.patterns.Order;

import good.patterns.Order.Model.Order;

public class ProductOrderRepository implements OrderRepository {
    @Override
    public void addOrder(Order order) {
        System.out.println("Adding order for: " + order.getUser());
    }
}
