package com.food.orders.ordersService.entity;

import com.food.orders.ordersService.enumPa.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OrderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;



}
