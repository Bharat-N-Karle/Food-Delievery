package com.food.restaurant.restaurantService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "menu_cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private Boolean isActive = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurantID")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menuCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuCardItem> items = new ArrayList<>();

    public void addItem(MenuCardItem item) {
        items.add(item);
        item.setMenuCard(this);
    }
}
