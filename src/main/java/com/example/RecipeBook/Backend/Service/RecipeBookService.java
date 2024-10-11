package com.example.RecipeBook.Backend.Service;

import com.example.RecipeBook.Backend.Model.Recipe;
import com.example.RecipeBook.Backend.Repository.RecipeBookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeBookService {

    @Autowired
    RecipeBookRepository recipeBookRepository;

    //Create

    public Recipe createRecipe(Recipe newRecipe) {
        return recipeBookRepository.save(newRecipe);
    }

    //Read

    public List<Recipe> getAllRecipes () {
        return recipeBookRepository.getAllRecipes();
    }

    public Recipe getRecipeById(long id) {
        return recipeBookRepository.getRecipeById(id);
    }

    //Update

    public void updateRecipe(Recipe newRecipe, long id) {
        newRecipe.setId(id);
        recipeBookRepository.save(newRecipe);
    }

    //Delete

    @Transactional
    public void deleteRecipe(long id) {
        recipeBookRepository.deleteRecipeById(id);
    }

}
