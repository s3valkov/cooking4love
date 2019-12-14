package org.s3valkov.cooking4love.repository;

import org.s3valkov.cooking4love.domain.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

    Optional<Recipe> findByName(String name);

    @Query("SELECT r FROM Recipe  AS r  order by r.time desc")
    List<Recipe> findAllAndOrderByTime();
}
