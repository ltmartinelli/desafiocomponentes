package com.desafiocomponentes.desafiocomponentes;

import com.desafiocomponentes.entities.Order;
import com.desafiocomponentes.services.OrderService;
import com.desafiocomponentes.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.desafiocomponentes"})
public class DesafiocomponentesApplication implements CommandLineRunner {

    private OrderService orderService;

    public DesafiocomponentesApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafiocomponentesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Código do Pedido: ");
        Integer code = sc.nextInt();
        System.out.print("Valor Básico: ");
        Double basic = sc.nextDouble();
        System.out.print("Porcentagem de Desconto: ");
        Double discount = sc.nextDouble();

        Order order = new Order(code, basic, discount);

        Double total = orderService.Total(order);

        System.out.println("Pedido código " + order.getCode());
        System.out.printf("Valor Total: %.2f%n", total);

        sc.close();

    }
}
