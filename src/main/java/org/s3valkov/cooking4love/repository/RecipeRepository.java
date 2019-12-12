package org.s3valkov.cooking4love.repository;

import org.s3valkov.cooking4love.domain.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {
}
