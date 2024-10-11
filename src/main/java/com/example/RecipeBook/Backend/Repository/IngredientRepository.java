package com.example.RecipeBook.Backend.Repository;

import com.example.RecipeBook.Backend.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query(value = "SELECT * FROM recipe_book.ingredient WHERE recipe_id = ?1", nativeQuery = true)
    List<Ingredient> getAllIngredients(long recipe_id);

    @Query(value = "SELECT id FROM recipe_book.ingredient WHERE recipe_id = ?1", nativeQuery = true)
    List<Long> getAllIds(long recipe_id);

    void deleteIngredientById(long id);
}
