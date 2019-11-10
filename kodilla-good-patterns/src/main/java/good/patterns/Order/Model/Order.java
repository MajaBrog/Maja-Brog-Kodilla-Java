package good.patterns.Order.Model;

import java.time.LocalDateTime;

public class Order {
    private User user;
    private OrderList orderList;
    private LocalDateTime orderDate;

    public Order(User user, OrderList orderList, LocalDateTime orderDate) {
        this.user = user;
        this.orderList = orderList;
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
