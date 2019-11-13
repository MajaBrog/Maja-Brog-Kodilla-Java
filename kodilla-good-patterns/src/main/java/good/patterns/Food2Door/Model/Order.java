package good.patterns.Food2Door.Model;

import good.patterns.Food2Door.Supplier;

import java.time.LocalDateTime;

public class Order {
    private Supplier supplier;
    private OrderList orderList;
    private LocalDateTime orderDate;

    public Order(Supplier supplier, OrderList orderList, LocalDateTime orderDate) {
        this.supplier = supplier;
        this.orderList = orderList;
        this.orderDate = orderDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getSupplierName() {
        return supplier.getClass().getSimpleName();
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "supplier=" + getSupplierName() +
                orderList +
                ", orderDate=" + orderDate +
                '}';
    }
}
