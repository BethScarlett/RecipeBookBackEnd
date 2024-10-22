package com.example.RecipeBook.Backend.Service;

import com.example.RecipeBook.Backend.Model.Ingredient;
import com.example.RecipeBook.Backend.Model.Recipe;
import com.example.RecipeBook.Backend.Model.Step;
import com.example.RecipeBook.Backend.Repository.IngredientRepository;
import com.example.RecipeBook.Backend.Repository.RecipeRepository;
import com.example.RecipeBook.Backend.Repository.StepRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeBookService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    StepRepository stepRepository;

    //Create

    public Recipe createRecipe (Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Ingredient> createIngredients (List<Ingredient> ingredients) {
        Recipe recipe = recipeRepository.getLastRecipe();
        for (Ingredient ingredient : ingredients) {
            ingredient.setRecipe(recipe);
            ingredientRepository.save(ingredient);
        }
        return ingredients;
    }

    public List<Step> createSteps (List<Step> steps) {
        Recipe recipe = recipeRepository.getLastRecipe();
        for (Step step : steps) {
            step.setRecipe(recipe);
            stepRepository.save(step);
        }
        return steps;
    }

    //Read

    public List<Recipe> getAllRecipes () {
        return recipeRepository.getAllRecipes();
    }

    public Recipe getRecipeById (long id) {
        return recipeRepository.getRecipeById(id);
    }

    public List<Ingredient> getAllIngredients (long id) {
        return ingredientRepository.getAllIngredients(id);
    }

    public List<Step> getAllSteps (long id) {
        return stepRepository.getAllSteps(id);
    }

    //Update

    public void updateRecipe (Recipe newRecipe, long id) {
        newRecipe.setId(id);
        recipeRepository.save(newRecipe);
    }

    @Transactional
    public void updateSteps (List<Step> steps, long recipe_id) {
        Recipe recipe = recipeRepository.getRecipeById(recipe_id);

        deleteSteps(recipe_id);

        for (Step step : steps) {
            step.setRecipe(recipe);
            stepRepository.save(step);
        }
    }

    @Transactional
    public void updateIngredients (List<Ingredient> ingredients, long recipe_id) {
        Recipe recipe = recipeRepository.getRecipeById(recipe_id);

        deleteIngredients(recipe_id);

        for (Ingredient ingredient : ingredients) {
            ingredient.setRecipe(recipe);
            ingredientRepository.save(ingredient);
        }
    }

    //Delete

    @Transactional
    public void deleteRecipe (long id) {
        deleteIngredients(id);

        deleteSteps(id);

        recipeRepository.deleteRecipeById(id);
    }

    @Transactional
    public void deleteSteps (long id) {
        List<Long> ids = stepRepository.getAllIds(id);
        for(long idToDelete: ids) {
            stepRepository.deleteStepById(idToDelete);
        }
    }

    @Transactional
    public void deleteIngredients (long id) {
        List<Long> ids = ingredientRepository.getAllIds(id);
        for(long idToDelete: ids) {
            ingredientRepository.deleteIngredientById(idToDelete);
        }
    }

}
