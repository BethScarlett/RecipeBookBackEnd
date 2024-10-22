package com.example.RecipeBook.Backend.Controller;

import com.example.RecipeBook.Backend.Model.Ingredient;
import com.example.RecipeBook.Backend.Model.Recipe;
import com.example.RecipeBook.Backend.Model.Step;
import com.example.RecipeBook.Backend.Service.RecipeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class RecipeBookController {

    @Autowired
    RecipeBookService recipeBookService;

    //CREATE

    @PostMapping("/recipe")
    public Recipe createRecipe (@RequestBody Recipe recipe) {
        return recipeBookService.createRecipe(recipe);
    }

    @PostMapping("/ingredient")
    public List<Ingredient> createIngredients (@RequestBody ArrayList<Ingredient> ingredients) {
        return recipeBookService.createIngredients(ingredients);
    }

    @PostMapping("/step")
    public List<Step> createSteps (@RequestBody ArrayList<Step> steps) {
        return recipeBookService.createSteps(steps);
    }

    //READ

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes () {
        return recipeBookService.getAllRecipes();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById (@PathVariable long id) {
        return recipeBookService.getRecipeById(id);
    }

    @GetMapping("/ingredients/{id}")
    public List<Ingredient> getAllIngredients(@PathVariable long id) {
        return recipeBookService.getAllIngredients(id);
    }

    @GetMapping("/steps/{id}")
    public List<Step> getAllSteps(@PathVariable long id) {
        return recipeBookService.getAllSteps(id);
    }

    //UPDATE

    @PutMapping("/recipes/{id}")
    public void updateRecipe (@RequestBody Recipe newRecipe, @PathVariable long id) {
        recipeBookService.updateRecipe(newRecipe, id);
    }

    @PutMapping("/steps/{id}")
    public void updateSteps (@RequestBody ArrayList<Step> steps, @PathVariable long id) {
        recipeBookService.updateSteps(steps, id);
    }

    @PutMapping("/ingredients/{id}")
    public void updateIngredients (@RequestBody ArrayList<Ingredient> ingredients, @PathVariable long id) {
        recipeBookService.updateIngredients(ingredients, id);
    }

    //DELETE

    @DeleteMapping("/recipes/{id}")
    public String deleteRecipe (@PathVariable long id) {
        recipeBookService.deleteRecipe(id);
        return "Recipe removed at id " + id;
    }

}
