package org.s3valkov.cooking4love.repository;

import org.s3valkov.cooking4love.domain.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    Optional<Restaurant> findByName(String name);

    @Query("SELECT r FROM Restaurant  AS r  order by r.rate desc")
    List<Restaurant> findAllAndOrderByRate();
}
