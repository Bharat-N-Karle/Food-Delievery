package com.food.restaurant.restaurantService.repository;

import com.food.restaurant.restaurantService.entity.MenuCardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MenuCardRepository extends JpaRepository<MenuCardItem, Long> {

    Optional<MenuCardItem> findByMenuCardIdAndItemName(Long id, String itemName);
}
