package good.patterns.Food2Door;

import good.patterns.Food2Door.Model.Order;

public class ExtraFoodShop implements Supplier {
    public void process(Order order){
        System.out.println("Sending order to ExtraFoodShop.");
    }
}
