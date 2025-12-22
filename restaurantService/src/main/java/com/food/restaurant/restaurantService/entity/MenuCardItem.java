package com.food.restaurant.restaurantService.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "menu_card_items")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCardItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String itemName;

    private String description;

    private String category;

    @Column(nullable = false)
    private Double price;

    private Boolean veg = true;

    private Boolean available = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_card_id")
    private MenuCard menuCard;
}
