package com.food.restaurant.restaurantService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantID")
    private Long id;

    @Column(name ="Restaurant_Name")
    private String name;

    @Column(name = "OrderID")
    private Long orderId;

    @Column(name = "Restaurant_Area")
    private String area;
}
