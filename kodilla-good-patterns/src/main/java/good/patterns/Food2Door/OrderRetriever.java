package good.patterns.Food2Door;

import good.patterns.Food2Door.Model.Order;
import good.patterns.Food2Door.Model.OrderList;

import java.time.LocalDateTime;

public class OrderRetriever {
    Order retrieve() {
        Supplier supplier = new GlutenFreeShop();
        OrderList orderList = new OrderList();
        orderList.addProduct("Carrot", 2);
        orderList.addProduct("Honey", 5);

        LocalDateTime orderDate = LocalDateTime.now();

        return new Order(supplier,orderList, orderDate);
    }
}
