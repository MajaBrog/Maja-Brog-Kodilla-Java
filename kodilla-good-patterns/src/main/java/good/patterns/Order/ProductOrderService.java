package good.patterns.Order;

import good.patterns.Order.Model.Order;

public class ProductOrderService implements OrderService{
    @Override
    public boolean order(Order order) {
        System.out.println("Order for " +order.getUser()+" was placed on " +order.getOrderDate());
        return true;
    }
}
