package good.patterns.Food2Door.Model;

import java.util.HashMap;
import java.util.Map;

public class OrderList {
    private Map<String, Integer> orderList=new HashMap<>();

    public Map<String, Integer> getOrderList() {
        return orderList;
    }

    public void addProduct(String product, int quantity) {
        orderList.put(product, quantity);
    }

    @Override
    public String toString() {
        return ", orderList=" + orderList ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderList order = (OrderList) o;

        return orderList != null ? orderList.equals(order.orderList) : order.orderList == null;
    }

    @Override
    public int hashCode() {
        return orderList != null ? orderList.hashCode() : 0;
    }
}