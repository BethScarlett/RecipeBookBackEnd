package com.example.RecipeBook.Backend.Repository;

import com.example.RecipeBook.Backend.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "SELECT * from recipe", nativeQuery = true)
    List<Recipe> getAllRecipes ();

    @Query(value = "SELECT * FROM recipe WHERE id = ?1", nativeQuery = true)
    Recipe getRecipeById (long id);

    @Query(value = "SELECT * FROM recipe_book.recipe ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Recipe getLastRecipe();

    void deleteRecipeById (long id);
}
