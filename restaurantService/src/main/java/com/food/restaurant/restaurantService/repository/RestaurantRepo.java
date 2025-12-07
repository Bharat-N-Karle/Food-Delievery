package com.food.restaurant.restaurantService.repository;

import com.food.restaurant.restaurantService.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {


    @Query("""
        SELECT DISTINCT r FROM Restaurant r
        LEFT JOIN FETCH r.menuCard mc
        LEFT JOIN FETCH mc.items
    """)
    List<Restaurant> findAllWithMenu();
}
