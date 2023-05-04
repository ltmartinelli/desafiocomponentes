package com.desafiocomponentes.services;

import com.desafiocomponentes.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double Total(Order order) {
        double shippingFee = shippingService.Shipment(order);
        double basic = order.getBasic();
        double discount = basic * (order.getDiscount()/100);

        return basic - discount + shippingFee;
    }

}
