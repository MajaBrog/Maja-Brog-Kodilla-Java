package good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRetriever {
    public Order retrieve() {
        Address deliveryAddress = new Address("Poland", "Warsaw", "1-176", "Tyszkiewicza", "15b", 8);
        User user = new User("MajaB", "Maja", "Brog", deliveryAddress, deliveryAddress);

        OrderList orderList=new OrderList();
        orderList.addProduct("123DA", 2);
        orderList.addProduct("12FGA", 5);

        LocalDateTime orderDate=LocalDateTime.now();

        return new Order(user, orderList,orderDate);
    }
}
