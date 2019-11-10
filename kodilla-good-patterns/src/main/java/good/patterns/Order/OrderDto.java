package good.patterns.Order;

import good.patterns.Order.Model.User;

public class OrderDto {
    private User user;
    private boolean orderPlaced;

    OrderDto(User user, boolean orderPlaced) {
        this.user = user;
        this.orderPlaced = orderPlaced;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrderPlaced() {
        return orderPlaced;
    }

}
