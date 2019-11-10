package good.patterns.Order;

import good.patterns.Order.Model.Address;
import good.patterns.Order.Model.Order;
import good.patterns.Order.Model.OrderList;
import good.patterns.Order.Model.User;

import java.time.LocalDateTime;

class OrderRetriever {
    Order retrieve() {
        Address deliveryAddress = new Address("Poland", "Warsaw", "01-176", "Tyszkiewicza", "15b", 8);
        User user = new User("MajaB", "Maja", "Brog", deliveryAddress, deliveryAddress, "majaB@gmail.com");

        OrderList orderList = new OrderList();
        orderList.addProduct("123DA", 2);
        orderList.addProduct("12FGA", 5);

        LocalDateTime orderDate = LocalDateTime.now();

        return new Order(user, orderList, orderDate);
    }
}
