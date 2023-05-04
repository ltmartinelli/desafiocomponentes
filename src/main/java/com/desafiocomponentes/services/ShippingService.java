package com.desafiocomponentes.services;

import com.desafiocomponentes.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public ShippingService() {
    }

    public double Shipment(Order order) {

        double shippingFee;

        if(order.getBasic() < 100.00){
            shippingFee = 20.00;
        }
        else if(order.getBasic() < 200.00){
            shippingFee = 12.00;
        }
        else{
            shippingFee = 0.00;
        }

        return shippingFee;

    }

}
