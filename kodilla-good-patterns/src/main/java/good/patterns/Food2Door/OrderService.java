package good.patterns.Food2Door;

import good.patterns.Food2Door.Model.Order;

public class OrderService {
    public boolean order(Order order) {
        System.out.println(order.toString()+ "has been accepted.");
        return true;
    }
}
