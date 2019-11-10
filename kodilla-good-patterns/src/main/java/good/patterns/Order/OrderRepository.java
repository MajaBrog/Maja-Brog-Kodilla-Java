package good.patterns.Order;

import good.patterns.Order.Model.Order;

public interface OrderRepository {
    void addOrder(Order order);
}
