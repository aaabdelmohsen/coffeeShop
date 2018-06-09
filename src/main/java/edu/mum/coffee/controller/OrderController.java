package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.OrderlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderlineService orderlineService;

    @Autowired
    Response customResponse;

    @PostMapping("create")
    public Order Create(@RequestBody Order order) {
        Order orderRes = orderService.save(order);
        return orderRes;
    }

    @PostMapping("createOrderline")
    public Orderline CreateOrderLine(@RequestBody Orderline orderline) {
        Orderline orderLineRes = orderlineService.save(orderline);
        return orderLineRes;
    }

    @GetMapping("list")
    public List<Order> List() {
        return orderService.findAll();
    }
}
