package som.cloud.make.well.order.web.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import som.cloud.make.well.order.web.data.pojo.Order;
import som.cloud.make.well.order.web.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") Long orderId, @RequestHeader("Truth") String truth) {
        System.out.println(truth);
        return orderService.queryOrderById(orderId);
    }

}
