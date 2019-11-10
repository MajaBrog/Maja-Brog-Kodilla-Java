package good.patterns.Order;

import good.patterns.Order.Model.Order;

class OrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    OrderProcessor(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    OrderDto process(final Order order) {
        boolean orderPlaced = orderService.order(order);


        if (orderPlaced) {
            informationService.inform(order.getUser());
            orderRepository.addOrder(order);
            return new OrderDto(order.getUser(), true);
        } else {
            return new OrderDto(order.getUser(), false);
        }
    }

}
